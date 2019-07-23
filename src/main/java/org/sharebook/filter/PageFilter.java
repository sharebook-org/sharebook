package org.sharebook.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/users")
public class PageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String method = request.getMethod();
        int defaultPage = 1;
        int defaultSize = 2;
        if (method.equals("GET")) {
            String page = request.getParameter("page");
            String size = request.getParameter("size");
            if (StringUtils.isBlank(page) || StringUtils.isBlank(size)) {
                String url = String.format("/users?page=%d&&size=%d", defaultPage, defaultSize);
                request.getRequestDispatcher(url).forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
