package com.example.demo.Repository;

import com.example.demo.dto.board.BoardDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.dto.user.UserDTO1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (username, password, name) VALUES (#{username}, #{password}, #{name})") //ユーザー登録
    void insertUser(UserDTO user);

    @Select("SELECT password FROM users WHERE username = #{username}") //암호화된 비밀번호 체크
    String checkpasswordExist(String username);

    @Select("SELECT COUNT(*) FROM users WHERE username = #{username}") //IDチェック
    int checkUsernameExist(String username);

    @Select("SELECT * FROM users ORDER BY created_at DESC")
    List<UserDTO1> getAllUsers();
}
