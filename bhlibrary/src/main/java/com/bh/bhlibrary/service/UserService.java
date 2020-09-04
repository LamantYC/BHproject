package com.bh.bhlibrary.service;

import com.bh.bhlibrary.Mapper.UserMapper;
import com.bh.bhlibrary.dao.UserDao;
import com.bh.bhlibrary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
//    private UserMapper userMapper;
    public boolean isExist(String username){
        User user = getByName(username);
        return null != user;
    }

    private User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User get(String username, String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userDao.save(user);
    }

//    public void addUser(String username, String password, String email, String phone, String realname){
//        userMapper.register(username,password,email,phone,realname);
//    }
//    public User getUser(String username){
//        return userMapper.selectByUserName(username);
//    }
}
