package com.example.demo.controller.user;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/") //ログインURL
    public String Login() {
        return "user/login";
    }

    @GetMapping("/user/signup") //会員登録画面 url
    public String signup() {
        return "user/signup";
    }

    @PostMapping("/user/signup") //会員登録機能 url
    public String signup(@RequestParam String username, @RequestParam String password, @RequestParam String passwordoky, @RequestParam String name, Model model) {
        UserDTO user = new UserDTO(username, password, passwordoky, name);
        if (!userService.signCheck(username)) { //ID重複チェック
            model.addAttribute("error", "아이디가 이미 존재합니다.");
            return "user/signup";
        }

        if (!user.getPassword().equals(user.getPasswordoky())) { //パスワード 二重チェック
            model.addAttribute("error", "비밀번호 확인이 일치하지 않습니다.");
            return "/user/signup";
        }
        userService.signupUser(user); //加入成功
        return "/board/boardread";
    }



}