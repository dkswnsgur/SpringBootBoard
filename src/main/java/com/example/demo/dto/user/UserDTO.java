package com.example.demo.dto.user;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {

    @NotEmpty(message = "아이디를 입력하세요.")
    private String username;
    @NotEmpty(message = "비밀번호를 입력하세요.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    private String password;

    @NotEmpty(message = "비밀번호 확인을 입력하세요.")
    private String passwordoky;

    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    public UserDTO() {}

    public UserDTO(String username, String password, String passwordoky, String name) {
        this.username = username;
        this.password = password;
        this.passwordoky = passwordoky;
        this.name = name;
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
}
