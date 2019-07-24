package org.sharebook.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/attention")
public class AttentionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String loginSuccess = (String) request.getSession().getAttribute("login");
        if (!StringUtils.isBlank(loginSuccess)) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    public void destroy() {
    }

}
