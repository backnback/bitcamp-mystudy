package bitcamp.myapp.servlet.project;

import bitcamp.myapp.service.ProjectService;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/project/view")
public class ProjectViewServlet extends HttpServlet {

  private ProjectService projectService;
  private UserService userService;

  @Override
  public void init() throws ServletException {
    projectService = (ProjectService) this.getServletContext().getAttribute("projectService");
    userService = (UserService) this.getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      int projectNo = Integer.parseInt(req.getParameter("no"));
      Project project = projectService.get(projectNo);
      req.setAttribute("project", project);

      List<User> users = userService.list();
      req.setAttribute("users", users);
      req.setAttribute("viewName", "/project/view.jsp");

    } catch (Exception e) {
      req.setAttribute("exception", e);
    }
  }
}
