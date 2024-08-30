package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project/delete")
public class ProjectDeleteServlet extends GenericServlet {

  private ProjectDao projectDao;
  private SqlSessionFactory sqlSessionFactory;

  @Override
  public void init() throws ServletException {
    this.projectDao = (ProjectDao) this.getServletContext().getAttribute("projectDao");
    this.sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    try {
      int projectNo = Integer.parseInt(req.getParameter("no"));

      projectDao.deleteMembers(projectNo);
      if (projectDao.delete(projectNo)) {
        sqlSessionFactory.openSession(false).commit();
        ((HttpServletResponse) res).sendRedirect("/project/list");
      } else {
        throw new Exception("없는 프로젝트입니다.");
      }

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }
}
