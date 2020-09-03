package lingye.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//包装Controller方法返回的数据
public class Response {
    private boolean success;//操作是否成功
    private String code;//错误码
    private String message;//错误信息
    private String stackTrack;//堆栈信息
    private Object data;//真实数据
}
