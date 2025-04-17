package com.example.demo.dto.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO1 {

    private String id;
    @NotEmpty(message = "아이디를 입력하세요.")
    private String username;
    @NotEmpty(message = "비밀번호를 입력하세요.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    private String password;

    @NotEmpty(message = "비밀번호 확인을 입력하세요.")
    private String passwordoky;

    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    private String created_at;

    public UserDTO1() {}

    public UserDTO1(String id, String username, String password, String passwordoky, String name, String created_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordoky = passwordoky;
        this.name = name;
        this.created_at = created_at;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordoky() {
        return passwordoky;
    }

    public void setPasswordoky(String passwordoky) {
        this.passwordoky = passwordoky;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
