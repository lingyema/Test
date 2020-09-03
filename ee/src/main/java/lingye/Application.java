package lingye;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "lingye.mapper")//MyBatis自动扫描接口
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
