package com.example.demo.Repository;

import com.example.demo.dto.user.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (username, password, name) VALUES (#{username}, #{password}, #{name})") //ユーザー登録
    void insertUser(UserDTO user);

    @Select("SELECT COUNT(*) FROM users WHERE username = #{username}") //IDチェック
    int checkUsernameExist(String username);
}
