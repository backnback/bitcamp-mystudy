package bitcamp.myapp.command.project;

import bitcamp.command.Command;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.util.Prompt;
import org.apache.ibatis.session.SqlSession;

public class ProjectUpdateCommand implements Command {

  private ProjectDao projectDao;
  private ProjectMemberHandler memberHandler;
  private SqlSession sqlSession;

  public ProjectUpdateCommand(ProjectDao projectDao,
                              ProjectMemberHandler memberHandler,
                              SqlSession sqlSession) {

    this.projectDao = projectDao;
    this.memberHandler = memberHandler;
    this.sqlSession = sqlSession;
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

      project.setTitle(Prompt.input("프로젝트명(%s)?", project.getTitle()));
      project.setDescription(Prompt.input("설명(%s)?", project.getDescription()));
      project.setStartDate(Prompt.inputDate("시작일(%s)?(예: 2024-01-24)", project.getStartDate()));
      project.setEndDate(Prompt.inputDate("종료일(%s)?(예: 2024-02-15)", project.getEndDate()));

      System.out.println("팀원:");
      memberHandler.deleteMembers(project);
      memberHandler.addMembers(project);

      projectDao.update(project);
      projectDao.deleteMembers(projectNo);
      if (project.getMembers() != null && project.getMembers().size() > 0) {
        projectDao.insertMembers(projectNo, project.getMembers());
      }
      sqlSession.commit();
      System.out.println("변경 했습니다.");

    } catch (Exception e) {
      sqlSession.rollback();
      System.out.println("변경 중 오류 발생!");
    }
  }

}
