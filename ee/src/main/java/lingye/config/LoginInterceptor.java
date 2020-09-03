package lingye.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    //Controller接受客户端请求，匹配道路及，并拦截到，进入方法前执行的逻辑
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);//如果没有session，不创建session
        if (session != null){//有登录
            //权限校验,通过返回true，让他访问；否则设置权限不通过的状态码（SpringMVC提供了）
//            session.getAttribute("user");
            return true;
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.sendRedirect("/login.html");
        return false;
    }
    //Controller方法执行完之后的逻辑
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
