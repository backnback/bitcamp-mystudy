package bitcamp.myapp.servlet.project;

import bitcamp.myapp.command.project.ProjectMemberHandler;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/project/add")
public class ProjectAddServlet extends GenericServlet {

  private ProjectDao projectDao;
  private ProjectMemberHandler memberHandler;
  private SqlSessionFactory sqlSessionFactory;

  @Override
  public void init() throws ServletException {
    ServletContext ctx = this.getServletContext();
    this.projectDao = (ProjectDao) ctx.getAttribute("projectDao");
    this.sqlSessionFactory = (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");

    PrintWriter out = res.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("    <meta charset='UTF-8'>");
    out.println("    <meta http-equiv='refresh' content='1;url=/project/list'>");
    out.println("    <title>Title</title>");
    out.println("    <link href='/css/common.css' rel='stylesheet'>");
    out.println("</head>");
    out.println("<body>");

    try {
      out.println("<header>");
      out.println("  <a href='/'><img src='/images/home.png'></a>");
      out.println("        프로젝트 관리 시스템");
      out.println("</header>");
      out.println("<h1>프로젝트 등록 결과</h1>");

      Project project = new Project();
      project.setTitle(req.getParameter("title"));
      project.setDescription(req.getParameter("description"));
      project.setStartDate(Date.valueOf(req.getParameter("startDate")));
      project.setEndDate(Date.valueOf(req.getParameter("endDate")));

      String[] memberNos = req.getParameterValues("member");
      if (memberNos != null) {
        ArrayList<User> members = new ArrayList<>();
        for (String memberNo : memberNos) {
          members.add(new User(Integer.parseInt(memberNo)));
        }
        project.setMembers(members);
      }

      projectDao.insert(project);

      if (project.getMembers() != null && project.getMembers().size() > 0) {
        projectDao.insertMembers(project.getNo(), project.getMembers());
      }
      sqlSessionFactory.openSession(false).commit();

      out.println("<p>등록 성공입니다.</p>");

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      out.println("<p>등록 중 오류 발생!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
