package com.example.demo.Repository;

import com.example.demo.dto.board.BoardDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO posts (title, content, author) VALUES (#{title}, #{content}, #{author})")
    void insertBoard(BoardDTO boardDTO);

    @Select("SELECT id, title, content, author, created_at FROM posts ORDER BY created_at DESC")
    List<BoardDTO> getAllBoards();

}
