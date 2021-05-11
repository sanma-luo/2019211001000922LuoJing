package com.LuoJing.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class FrontEndAuthenticationFilter implements Filter {
    private HttpServletRequest httpRequest;
    private static  final  String[] loginRequiredURLs = {
            "/updateUser","/logout","/myCart"
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        httpRequest = (HttpServletRequest) servletRequest;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if(path.startsWith("/admin/"))
        {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session!=null && session.getAttribute("user") != null);
        String loginURI = httpRequest.getContextPath()+"/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");

        if(isLoggedIn && (isLoginRequest || isLoginPage))
        {
            httpRequest.getRequestDispatcher("/").forward(servletRequest, servletResponse);

        }else  if(!isLoggedIn && isLoginRequired())
        {
            String loginPage = "/login";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(servletRequest, servletResponse);
        }
        else
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    private boolean isLoginRequired() {
        String requestURL =  httpRequest.getRequestURL().toString();
        for (String loginRequiredURL:loginRequiredURLs) {

            if (requestURL.contains(loginRequiredURL))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}