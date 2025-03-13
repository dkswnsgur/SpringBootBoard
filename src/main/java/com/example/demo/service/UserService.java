package com.example.demo.service;

import com.example.demo.Repository.UserMapper;
import com.example.demo.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //暗号化

    public void signupUser(UserDTO user) { //ユーザー登録サービス
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userMapper.insertUser(user);
    }

    public boolean signCheck(String username) { //ID重複チェック機能
        int userCount = userMapper.checkUsernameExist(username);
        return userCount == 0;
    }

}
