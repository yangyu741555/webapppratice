package com.example.webapppratice01.mapper;

import com.example.webapppratice01.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void addUser(User user);

    @Select("SELECT * from user where username=#{username}")
    User getuser(String username);

    @Select("SELECT * from user where username=#{username} and password=#{password}")
    User login(String username,String password);
}
