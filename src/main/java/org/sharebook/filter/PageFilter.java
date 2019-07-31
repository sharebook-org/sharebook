package org.sharebook.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/users", "/articles"})
public class PageFilter implements Filter {

    private final static int DEFAULT_PAGE = 1;
    private final static int DEFAULT_SIZE = 10;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String method = request.getMethod();
        int page = DEFAULT_PAGE;
        int size = DEFAULT_SIZE;
        if (method.equals("GET")) {
            String currentPage = request.getParameter("page");
            String currentSize = request.getParameter("size");
            if (!StringUtils.isBlank(currentPage)) {
                page = Integer.parseInt(currentPage);
            }
            if (!StringUtils.isBlank(currentSize)) {
                size = Integer.parseInt(currentSize);
            }
            request.getRequestDispatcher(
                    String.format("/%s?page=%d&&size=%d", request.getServletPath(), page, size)
            ).forward(request, response);
        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
