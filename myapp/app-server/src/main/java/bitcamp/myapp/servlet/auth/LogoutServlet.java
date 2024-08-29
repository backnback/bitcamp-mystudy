package bitcamp.myapp.servlet.auth;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/logout")
public class LogoutServlet extends GenericServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    ((HttpServletRequest) req).getSession().invalidate();
    ((HttpServletResponse) res).sendRedirect("/");
  }
}
