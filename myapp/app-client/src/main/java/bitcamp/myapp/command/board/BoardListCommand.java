package bitcamp.myapp.command.board;

import bitcamp.command.Command;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class BoardListCommand implements Command {

  private BoardDao boardDao;

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    try {
      System.out.println("번호 제목 작성자 작성일 조회수");

      for (Board board : boardDao.list()) {
        System.out.printf("%d %s %s %tY-%4$tm-%4$td %d\n",
                board.getNo(),
                board.getTitle(),
                board.getWriter().getName(),
                board.getCreatedDate(),
                board.getViewCount());
      }
    } catch (Exception e) {
      System.out.println("목록 조회 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
