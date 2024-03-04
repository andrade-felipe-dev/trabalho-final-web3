package br.edu.ifpr.irati.ads.servelets.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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


@WebFilter(urlPatterns = {"/"})
public class AuthFilter implements Filter {

	private Cookie getUser(HttpServletRequest httpReq) {
		Cookie[] cookies = httpReq.getCookies();
		Cookie name = null;

		if (cookies != null) {
			for (Cookie c: cookies) {
				if (c.getName().equals("name")) {
					name = c;
					break;
				}
			}
		}

		return name;
	}

	private boolean validarToken(Cookie token) {
		return false;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Teste");
		Cookie userCookie = getUser((HttpServletRequest) request);
		boolean valido = validarToken(userCookie);

		if (valido) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResp = (HttpServletResponse) response;
			httpResp.sendRedirect("/login.jsp");
			httpResp.getWriter().println("Token inválido. Por favor, faça o login.");
		}
	}
}
