package bitcamp.myapp.command.project;

import bitcamp.command.Command;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;
import java.util.List;

public class ProjectViewCommand implements Command {

  private ProjectDao projectDao;

  public ProjectViewCommand(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int projectNo = Prompt.inputInt("프로젝트 번호?");

    try {
      Project project = projectDao.findBy(projectNo);
      if (project == null) {
        System.out.println("없는 프로젝트입니다.");
        return;
      }

      System.out.printf("프로젝트명: %s\n", project.getTitle());
      System.out.printf("설명: %s\n", project.getDescription());
      System.out.printf("기간: %s ~ %s\n", project.getStartDate(), project.getEndDate());

      List<User> members = projectDao.getMembers(projectNo);
      System.out.println("팀원:");
      for (User user : members) {
        System.out.printf("- %s\n", user.getName());
      }
    } catch (Exception e) {
      System.out.println("조회 중 오류 발생!");
    }
  }
}
