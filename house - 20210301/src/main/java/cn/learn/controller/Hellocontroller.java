package cn.learn.controller;

import cn.learn.pojo.User;
import cn.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class Hellocontroller {
    @Autowired
    private UserService userService;
    @RequestMapping("/hello")
    public String hello(ModelMap modelMap){
//        List<User> users = userService.getUsers();
//        User user = users.get(0);
        User user=new User();
        user.setName("wangzhi");
        modelMap.put("user",user);
        return "hello";
    }

    @RequestMapping("/index")
    public String index(){
        return "homepage/index";
    }
}
