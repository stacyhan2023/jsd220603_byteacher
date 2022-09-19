package cn.tedu.coolshark.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = {"/admin.html","/insertProduct.html"})
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器开始执行");
        chain.doFilter(request, response);
    }
}
