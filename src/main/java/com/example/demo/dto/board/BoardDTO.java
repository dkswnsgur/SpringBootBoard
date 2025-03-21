package com.example.demo.dto.board;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class BoardDTO {
    private String id;
    @NotEmpty(message = "제목을 입력하세요.")
    private String title;
    @NotEmpty(message = "내용을 입력하세요.")
    private String content;

    private String author;

    private Date created_at;

    public BoardDTO() {}

    public BoardDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
