package lingye.controller;

import lingye.model.User;
import lingye.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@RequestMapping("/1")
@Controller
public class LoginController {
    //使用@Autowired或@Resource可以使用bean
    @Resource
    private LoginService loginService;
    @Autowired
    @Qualifier("user1")
    private User user;
    @Resource(name = "user2")
    private User user1;

    @RequestMapping("/login")
    public String login(Integer i) {
        System.out.println(loginService);
        System.out.println(user);
        System.out.println(user1);
        if (i == 1){
            return "redirect:/index.html";
        }else {
            return "forward:/index.html";
        }
    }
    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    @ResponseBody
    public Object login1(@RequestBody User user){
        System.out.println(user);
        return user;
    }
    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    public Object login2(HttpServletRequest request, HttpServletResponse response,
                         User user){
        if ("abc".equals(user.getUserName()) && "123".equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return user;
        }
        throw new RuntimeException("登录不成功");
    }
}
