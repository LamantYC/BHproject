package com.bh.bhlibrary.Mapper;

import com.bh.bhlibrary.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

//    @Insert("insert into user(username,password,phone,email) values(#{username},#{password},#{phone},#{email})")
//    void register(String username, String password, String email, String phone, String realname);
//    User getUserByUsernameAndPasswordTest(String username,String password);
//    User selectByUserName(String username);
}
