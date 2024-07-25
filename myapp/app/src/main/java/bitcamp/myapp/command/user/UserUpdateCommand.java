package bitcamp.myapp.command.user;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;

public class UserUpdateCommand implements Command {

  private UserDao userDao;

  public UserUpdateCommand(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int userNo = Prompt.inputInt("회원번호?");

    try {
      User user = userDao.findBy(userNo);
      if (user == null) {
        System.out.println("없는 회원입니다.");
        return;
      }

      user.setName(Prompt.input("이름(%s)?", user.getName()));
      user.setEmail(Prompt.input("이메일(%s)?", user.getEmail()));
      user.setPassword(Prompt.input("암호?"));
      user.setTel(Prompt.input("연락처(%s)?", user.getTel()));

      if (userDao.update(user)) {
        System.out.println("변경 했습니다.");
      } else {
        System.out.println("변경 실패입니다!");
      }
      
    } catch (Exception e) {
      System.out.println("데이터 변경 중 오류 발생!");
    }
  }

}
