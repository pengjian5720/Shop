package com.briup.web.filter;

import com.briup.bean.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter")
public class LoginCheckFilter implements Filter {
    private String weboot=null;
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpSession session=request.getSession(false);
        String uri=request.getRequestURI();
        request.setCharacterEncoding("GBK");
        if(session==null){
            response.sendRedirect(weboot+"/login.jsp");
            }
        else {
            Customer customer=(Customer)session.getAttribute("customer");
            if (customer == null) {
                response.sendRedirect(weboot + "/login.jsp");
            } else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext application=config.getServletContext();
        weboot=application.getContextPath();
    }

}
