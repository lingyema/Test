package lingye.config;

import lingye.model.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@ControllerAdvice+实现ResponseBodyAdvice接口--->包装所有Controller方法返回的结果
@ControllerAdvice//拦截所有Controller方法
public class ResponseAdvisor implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //获取请求方法对象（通过反射）,判断Controller方法上是否有@ResponseBody
        return methodParameter.getMethod().getAnnotation(ResponseBody.class) != null;
    }

    /**
     * 包装所有Controller方法返回的结果（这里是对json数据包装）
     * 上面方法返回true，执行；返回false，不执行
     * @param o 请求方法执行完后返回的对象
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Response response = new Response();
        response.setSuccess(true);
        response.setData(o);
        return response;
    }

}
