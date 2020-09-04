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
        System.out.println(username);
        User user = userService.get(username,requestUser.getPassword());
        if (null == user){
            return new Result(400);
        }else {
            session.setAttribute("user",user);
            return new Result(200);
        }
    }

    /**用户不存在则增加一条记录新增用户*/
//    @CrossOrigin
//    @PostMapping("/api/addUser")
//    @ResponseBody
//    public Result addUser(@RequestBody User requestUser) {
//        String username = requestUser.getUsername();
//        String password = requestUser.getPassword();
//        String phone = requestUser.getPhone();
//        String realname = requestUser.getRealname();
//        String email = requestUser.getEmail();
//        User user = userService.getUser(username);
//        if (user == null) {
//            userService.addUser(username, password, email, phone, realname);//用户不存 在则出入一条记录
//            return new Result(200);//返回自定义 result 对象
//            }
//        return new Result(400);
//        }
    }
