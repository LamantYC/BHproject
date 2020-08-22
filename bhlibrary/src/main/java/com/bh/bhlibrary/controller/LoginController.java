package com.bh.bhlibrary.controller;

import com.bh.bhlibrary.entity.User;
import com.bh.bhlibrary.result.Result;
import com.bh.bhlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;
/**
 * @author 17331
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        //转义 html 标签，防止 xss 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
//        if (!Objects.equals("admin", username) ||
//                !Objects.equals("123456", requestUser.getPassword())) {
//            String message = "账号密码错误";
//            System.out.println(message);
//            return new Result(400);
//        } else {
//            System.out.println("登陆成功");
//            return new Result(200);
//        }
        User user = userService.get(username,requestUser.getPassword());
        if (null == user){
            System.out.println("登陆失败");
            return new Result(400);
        }else {
            session.setAttribute("user",user);
            System.out.println("登陆成功");
            return new Result(200);
        }
    }

}
