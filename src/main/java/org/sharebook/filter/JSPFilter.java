package org.sharebook.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSP过滤器
 * 用于过滤类似"index.jsp"的请求，将其变为"/index"的请求。
 * 原因：页面是由servlet控制。
 */
@WebFilter(urlPatterns = "*.jsp")
public class JSPFilter implements Filter {

    private final String suffix = ".jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getRequestURI();
        if (path.endsWith(suffix)) {
            int index = path.indexOf(".");
            String servletPath = path.substring(0, index);
            request.getRequestDispatcher(servletPath).forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
