package bitcamp.myapp.command.user;

import bitcamp.command.Command;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;
import org.apache.ibatis.session.SqlSession;

public class UserDeleteCommand implements Command {

  private UserDao userDao;
  private SqlSession sqlSession;

  public UserDeleteCommand(UserDao userDao, SqlSession sqlSession) {

    this.userDao = userDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int userNo = Prompt.inputInt("회원번호?");

    try {
      User deletedUser = userDao.findBy(userNo);
      if (deletedUser == null) {
        System.out.println("없는 회원입니다.");
        return;
      }

      userDao.delete(userNo);
      sqlSession.commit();
      System.out.printf("'%s' 회원을 삭제 했습니다.\n", deletedUser.getName());

    } catch (Exception e) {
      sqlSession.rollback();
      System.out.println("삭제 중 오류 발생!");
    }
  }
}
