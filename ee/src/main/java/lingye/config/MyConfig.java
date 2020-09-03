package lingye.config;

import lingye.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//将配置类设置在SpringMVC中,设置成bean对象
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())//所有匹配的路径都会进入拦截器
                .addPathPatterns("/1/**")//**代表所有子路径（包括多级），*只能匹配一级路径
                .excludePathPatterns("/1/login2");
    }
    //定义一个bean返回到容器中,bean名称是方法名;建议定义在配置类中，因为配置类加载的早，不会出现没有获取到的问题
    @Bean
    public User user1(){
        User u = new User();
        u.setUserName("张三");
        return u;
    }
    @Bean
    public User user2(@Qualifier("user1") User user1){
        System.out.println(user1);
        User u = new User();
        u.setUserName("李四");
        return u;
    }
}
