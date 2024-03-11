package br.edu.ifpr.irati.ads.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class CookieUtil {
  public Cookie getEmail(HttpServletRequest httpReq) {
    Cookie[] cookies = httpReq.getCookies();
    Cookie email = null;

    if (cookies != null) {
      for (Cookie c: cookies) {
        if (c.getName().equals("email")) {
          email = c;
          break;
        }
      }
    }

    return email;
  }
}
