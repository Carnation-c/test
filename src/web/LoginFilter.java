package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",value = "/*",dispatcherTypes = DispatcherType.INCLUDE)
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1. 获取资源的请求路径
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        //2. 判断是否包含登陆相关的资源
        if (requestURI.contains("/login.jsp")||requestURI.contains("/LoginServlet")||requestURI.contains("/CheckCodeServlet")||
                requestURI.contains("/css")||requestURI.contains("/js")||requestURI.contains("/fonts/")){
            //包含，放行
            chain.doFilter(req, resp);
        }else{
            //不包含，需要用session验证用户是否登录
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //证明用户已经登陆，放行即可
                chain.doFilter(req, resp);
            }else {
                //储存错误信息
                request.setAttribute("login_msg","您尚未登陆，请注册或登录！！！");
                //请求转发
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
