package com.bh.bhlibrary.controller;

import com.bh.bhlibrary.entity.User;
import com.bh.bhlibrary.result.Result;
import com.bh.bhlibrary.result.ResultFactory;
import com.bh.bhlibrary.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value = "登录" ,  notes="1231231")
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        User user1= userService.getUser(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, user.getPassword());
        try {
            subject.login(usernamePasswordToken);
            System.out.println(user1);
            System.out.println(subject.isAuthenticated());
            System.out.println(ResultFactory.buildSuccessResult(user1));
            return ResultFactory.buildSuccessResult(user1);
        } catch (AuthenticationException e) {
            String message = "账号密码错误！";
            return ResultFactory.buildFailResult(message);
        }
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/api/adduser")
    public Result register(@RequestBody User user) {
        //获取用户信息
        String username = user.getUsername();
        System.out.println(username);
        String password = user.getPassword();
        System.out.println(password);
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        // 判断用户名不能为空
        if (username.equals("")) {
            String message = "用户名不能为空！";
            return ResultFactory.buildFailResult(message);
        }
        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "该用户名已被占用！";
            return ResultFactory.buildFailResult(message);
        }
        //生成盐，默认为 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //设置 hash 迭代次数
        int times = 2;
        //得到 hash 运算值
        String encodePassword = new SimpleHash("md5", password, salt,
                times).toString();
        //存储用户信息--salt 及 hash 运算值
        user.setSalt(salt);
        user.setPassword(encodePassword);
        userService.add(user);
        return ResultFactory.buildSuccessResult(user); }
    }
