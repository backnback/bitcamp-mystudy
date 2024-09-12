package bitcamp.myapp.servlet.user;

import bitcamp.myapp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {

  private UserService userService;

  @Override
  public void init() throws ServletException {
    this.userService = (UserService) this.getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      int userNo = Integer.parseInt(req.getParameter("no"));

      if (userService.delete(userNo)) {
        req.setAttribute("viewName", "redirect:list");
      } else {
        throw new Exception("없는 회원입니다.");
      }

    } catch (Exception e) {
      req.setAttribute("exception", e);
    }
  }
}
