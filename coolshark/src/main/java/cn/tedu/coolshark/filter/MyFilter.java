package cn.tedu.coolshark.filter;

import cn.tedu.coolshark.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpServletRequest rt = (HttpServletRequest) request;
        HttpServletResponse re = (HttpServletResponse) response;
        //从请求对象中获取Session
        HttpSession session = rt.getSession();
        //获取用户对象
        User user = (User) session.getAttribute("user");
        if (user!=null){//登录过
            //执行此代码才能让客户端请求到资源 不执行代表拦截
            chain.doFilter(request, response);
        }else{//未登录
            re.sendRedirect("/login.html");//重定向到登录页面
        }
    }
}
