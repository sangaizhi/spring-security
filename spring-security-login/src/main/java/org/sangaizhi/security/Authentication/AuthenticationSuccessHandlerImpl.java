package org.sangaizhi.security.Authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sangaizhi
 * @date 2017/7/5
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
		Authentication authentication) throws IOException, ServletException {
	    httpServletResponse.sendRedirect("loginSuccess.jsp");
	}
}
