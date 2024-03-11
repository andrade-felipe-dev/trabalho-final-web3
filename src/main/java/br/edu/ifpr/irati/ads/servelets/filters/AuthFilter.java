package br.edu.ifpr.irati.ads.servelets.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import br.edu.ifpr.irati.ads.controls.UserController;
import br.edu.ifpr.irati.ads.models.user.User;
import br.edu.ifpr.irati.ads.utils.CookieUtil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = {
				"/",
				"/tickets/listar",
				"/tickets/editar",
				"/tickets/salvar",
				"/tickets/excluir"
	}
)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		UserController userController = new UserController();
		CookieUtil cookieUtil = new CookieUtil();

		Cookie userCookie = cookieUtil.getEmail((HttpServletRequest) request);
		User user = userController.findEmail(userCookie.getValue());

		if (user != null) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResp = (HttpServletResponse) response;
			httpResp.sendRedirect("/login.jsp");
			httpResp.getWriter().println("Email inválido. Por favor, faça o login.");
		}
	}
}
