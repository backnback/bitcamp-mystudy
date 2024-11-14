package bitcamp.myapp.controller;


import bitcamp.myapp.security09.CustomUserDetails;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

  private static final Log log = LogFactory.getLog(AuthController.class);
  private final UserService userService;

  @GetMapping("form")
  public void form(@CookieValue(required = false) String email, Model model) {
    model.addAttribute("email", email);
  }

  @PostMapping("success")
  public String success(
      @AuthenticationPrincipal CustomUserDetails principal,
      boolean saveEmail,
      HttpServletResponse res,
      HttpSession session) throws Exception {


    User user = principal.getUser();

    if (saveEmail) {
      Cookie cookie = new Cookie("email", user.getEmail());
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

}
