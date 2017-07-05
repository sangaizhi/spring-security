package org.sangaizhi.security.Authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败后的请求处理
 * @author sangaizhi
 * @date 2017/7/5
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect("loginFailure");
    }
}
