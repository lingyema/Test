package lingye.config;

import lingye.model.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice+@ExceptionHandler(Exception.class)--->处理所有Controller方法抛出的异常
@ControllerAdvice//处理Controller中抛出的异常，提供异常处理逻辑
/**
 * 返回错误数据
 */
public class ExceptionAdvisor {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e) {//Controller方法抛出的错误信息自动装到这里（e）
        Response response = new Response();
        response.setCode("USR001");
        response.setMessage("用户名密码错误，登录失败");
        response.setStackTrack(e.toString());
        response.setData(null);
        return response;
    }
//@ExceptionHandler(Exception.class)//拦截异常
///**
// * 返回错误页面
// */
//public String handle(HttpServletResponse response) {//Controller方法抛出的错误信息自动装到这里（e）
//    try {
//        response.sendRedirect("/error.html");
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    return null;
//}
}
