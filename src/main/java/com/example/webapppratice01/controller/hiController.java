package com.example.webapppratice01.controller;

import com.example.webapppratice01.mapper.UserMapper;
import com.example.webapppratice01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class hiController {
    @Autowired
    private UserMapper usermapper;
    @GetMapping("/register")
    public String reg(){
        return "register";
    }
    @RequestMapping("/register")
    public String register(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        User user1 = usermapper.getuser(username);
        if (user1!=null){
            map.put("msg1","the user has been registered,please register again!");
            return  "register";
        }else {
            usermapper.addUser(user);
            return  "login";
        }

    }

    @RequestMapping("/getuser")
    public String getuser(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        User user=usermapper.getuser(username);
        if (user!=null){
            map.put("msg","the user has been registered!");
            return  "register";
        }else {
            map.put("msg","the user has not been used");
            return "register";
        }
    }

    @RequestMapping("/login")
    public  String login(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser = usermapper.login(username, password);
        System.out.println(loginuser);
        map.put("msg2","the user "+loginuser+"login");
        return  "login";
    }

}
