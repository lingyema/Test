package lingye.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class User {
    private String userName;
    private String password;
    private Date birthday;
}
