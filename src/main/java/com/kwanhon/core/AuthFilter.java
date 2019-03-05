package com.kwanhon.core;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Doaim on 2017/4/24.
 */
public class AuthFilter implements Filter {
    private Pattern pattern = Pattern.compile(".*(\\.jpg|\\.png|\\.gif|\\.css|\\.js)$|/user/checkUser|/user/login");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        if(pattern.matcher(httpServletRequest.getPathInfo()).matches()) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            if((httpServletRequest.getSession().getAttribute("currentUser") == null)){
                ((HttpServletResponse)servletResponse).sendRedirect(httpServletRequest.getContextPath() + "/" +httpServletRequest.getServletPath()+"/user/login");
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
