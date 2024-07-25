package bitcamp.myapp.command.project;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.util.Prompt;

public class ProjectDeleteCommand implements Command {

  private ProjectDao projectDao;

  public ProjectDeleteCommand(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int projectNo = Prompt.inputInt("프로젝트 번호?");

    try {
      Project deletedProject = projectDao.findBy(projectNo);
      if (deletedProject == null) {
        System.out.println("없는 프로젝트입니다.");
        return;
      }

      if (projectDao.delete(projectNo)) {
        System.out.printf("'%s' 프로젝트을 삭제 했습니다.\n", deletedProject.getTitle());
      } else {
        System.out.println("삭제 실패입니다!");
      }

    } catch (Exception e) {
      System.out.println("데이터 삭제 중 오류 발생!");
    }
  }
}
