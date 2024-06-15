package bitcamp.myapp;

public class TeamCommand {

  static final int MAX_SIZE = 10;
  static User[][] team = new User[MAX_SIZE][MAX_SIZE];
  static String[] teamName = new String[MAX_SIZE];
  static int teamLength = 0;

  static void executeTeamCommand(String command) {
    System.out.printf("[%s]\n", command);

    switch (command) {
      case "등록":
        addTeam();
        break;
      case "조회":
        viewTeam();
        break;
      case "목록":
        listTeam();
        break;
      case "변경":
        updateTeam();
        break;
      case "삭제":
        deleteTeam();
        break;
    }
  }

  static void addTeam() {
    teamName[teamLength] = Prompt.input("팀명?");
    int userLength = UserCommand.userLength;
    User[] users = UserCommand.users;
    int teamMemberLength = 0;

    while (true) {
      int userNo = Integer.parseInt(Prompt.input("추가할 팀원 번호?(종료: 0)"));
      if (userNo == 0) {
        System.out.println("등록 했습니다.");
        break;
      } else if (userNo < 1 || userNo > userLength) {
        System.out.println("없는 회원입니다.");
      } else {
        team[teamLength][teamMemberLength] = users[userNo - 1];
        teamMemberLength++;
        System.out.printf("'%s'을 추가했습니다.\n", users[userNo - 1].name);
      }
    }
    teamLength++;
  }

  static void viewTeam() {
    int teamNo = Integer.parseInt(Prompt.input("팀 번호?"));
    if (teamNo < 1 || teamNo > teamLength) {
      System.out.println("없는 팀입니다.");
      return;
    }
    System.out.printf("팀명: %s\n", teamName[teamNo - 1]);
    System.out.println("팀원");
    for (int i = 0; i < team[teamNo - 1].length; i++) {
      if (team[teamNo - 1][i] != null) {
        System.out.printf("- %s\n", team[teamNo - 1][i].name);
      }
    }
  }

  static void listTeam() {
    System.out.println("번호 팀명");
    for (int i = 0; i < teamLength; i++) {
      System.out.printf("%d %s\n", (i + 1), teamName[i]);
    }
  }

  static void updateTeam() {
    System.out.println("update");
  }

  static void deleteTeam() {
    System.out.println("delete");
  }

}
