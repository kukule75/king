package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author kinden
 */
public class HelloFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("HelloFilter ...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
