package com.LuoJing.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


//@WebFilter(filterName = "HelloFilter",value = "/*")
@WebFilter(filterName = "HelloFilter",value = {"/login","/register.jsp","/home"})
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("i am in helloFilter destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("before request");
        chain.doFilter(req, resp);
        System.out.println("after respones");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in helloFilter init()");
    }

}
