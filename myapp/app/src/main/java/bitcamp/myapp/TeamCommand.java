package bitcamp.myapp;

public class TeamCommand {

  static final int MAX_SIZE = 10;
  static User[][] team = new User[MAX_SIZE][MAX_SIZE];
  static String[] teamName = new String[MAX_SIZE];
  static int teamLength = 0;
  static int[] teamMemberLength = new int[MAX_SIZE];

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
    int MemberLength = 0;

    while (true) {
      int userNo = Integer.parseInt(Prompt.input("추가할 팀원 번호?(종료: 0)"));
      if (userNo == 0) {
        System.out.println("등록 했습니다.");
        break;
      } else if (userNo < 1 || userNo > userLength) {
        System.out.println("없는 회원입니다.");
      } else {
        team[teamLength][MemberLength] = users[userNo - 1];
        MemberLength++;
        System.out.printf("'%s'을 추가했습니다.\n", users[userNo - 1].name);
      }
    }
    teamMemberLength[teamLength] = MemberLength;
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
    for (int i = 0; i < teamMemberLength[teamNo - 1]; i++) {
      System.out.printf("- %s\n", team[teamNo - 1][i].name);
    }
  }

  static void listTeam() {
    System.out.println("번호 팀명");
    for (int i = 0; i < teamLength; i++) {
      System.out.printf("%d %s\n", (i + 1), teamName[i]);
    }
  }

  static void updateTeam() {
    int teamNo = Integer.parseInt(Prompt.input("팀 번호?"));
    if (teamNo < 1 || teamNo > teamLength) {
      System.out.println("없는 팀입니다.");
      return;
    }
    teamName[teamNo - 1] = Prompt.input(String.format("이름(%s)?", teamName[teamNo - 1]));
    for (int i = 0; i < teamMemberLength[teamNo - 1]; i++) {
      String answer = Prompt.input(String.format("팀원(%s) 삭제?", team[teamNo - 1][i].name));
      if (answer.equals("y") || answer.equals("Y")) {
        for (int j = i; j < teamMemberLength[teamNo - 1]; j++) {
          team[teamNo - 1][j] = team[teamNo - 1][j + 1];
        }
        teamMemberLength[teamNo - 1]--;
        team[teamNo - 1][teamMemberLength[teamNo - 1]] = null;
        System.out.printf("'%s' 팀원을 삭제합니다.\n", team[teamNo - 1][i].name);
      } else {
        System.out.printf("'%s' 팀원을 유지합니다.\n", team[teamNo - 1][i].name);
      }
    }
    System.out.println("변경했습니다.");
  }

  static void deleteTeam() {
    int teamNo = Integer.parseInt(Prompt.input("팀 번호?"));
    if (teamNo < 1 || teamNo > teamLength) {
      System.out.println("없는 팀입니다.");
      return;
    }
    for (int i = teamNo; i < teamLength; i++) {
      team[i - 1] = team[i];
      teamName[i - 1] = teamName[i];
    }
    teamLength--;
    team[teamLength] = null;   // 가비지 처리
    teamName[teamLength] = null;
    System.out.println("삭제 했습니다.");
  }

}
