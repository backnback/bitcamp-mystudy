package bitcamp.myapp.controller;


import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

  private UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("form")
  public void form() {
  }

  @PostMapping("login")
  public String login(
      String email,
      String password,
      boolean saveEmail,
      HttpServletResponse res,
      HttpSession session) throws Exception {

    User user = userService.exists(email, password);
    if (user == null) {
      res.setHeader("Refresh", "2; url=form");
      return "auth/fail";
    }

    if (saveEmail) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 7);
      res.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "test@test.com");
      cookie.setMaxAge(0);
      res.addCookie(cookie);
    }

    session.setAttribute("loginUser", user);
    return "redirect:/";
  }

  @GetMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

}
