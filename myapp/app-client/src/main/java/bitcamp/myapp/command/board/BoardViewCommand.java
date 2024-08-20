package bitcamp.myapp.command.board;

import bitcamp.command.Command;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import org.apache.ibatis.session.SqlSession;

public class BoardViewCommand implements Command {

  private BoardDao boardDao;
  private SqlSession sqlSession;

  public BoardViewCommand(BoardDao boardDao, SqlSession sqlSession) {

    this.boardDao = boardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int boardNo = Prompt.inputInt("게시글 번호?");

    try {
      Board board = boardDao.findBy(boardNo);
      if (board == null) {
        System.out.println("없는 게시글입니다.");
        return;
      }

      board.setViewCount(board.getViewCount() + 1);
      boardDao.updateViewCount(board.getNo(), board.getViewCount());
      sqlSession.commit();

      System.out.printf("제목: %s\n", board.getTitle());
      System.out.printf("내용: %s\n", board.getContent());
      System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.getCreatedDate());
      System.out.printf("조회수: %d\n", board.getViewCount());
      System.out.printf("작성자: %s\n", board.getWriter().getName());

    } catch (Exception e) {
      sqlSession.rollback();
      System.out.println("조회 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
