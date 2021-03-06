package com.example.webapppratice01.mapper;

import com.example.webapppratice01.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void addUser(User user);

    @Select("SELECT * from user where username=#{username}")
    User getuser(String username);

    @Select("SELECT * from user where username=#{username} and password=#{password}")
    User login(String username,String password);

    @Delete("DELETE from user where username=#{username}")
    void deleteuser(String username);

    @Update("update user set password=#{password} where username=#{username}")
    void updateuser(String username,String password);
}
