package com.example.demo.Repository;

import com.example.demo.dto.board.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO posts (title, content, author) VALUES (#{title}, #{content}, #{author})")
    void insertBoard(BoardDTO boardDTO);

    @Select("SELECT id, title, content, author, created_at FROM posts ORDER BY created_at DESC")
    List<BoardDTO> getAllBoards();

    @Select("SELECT * FROM posts WHERE id = #{id}")
    BoardDTO getBoardById(Long id);

    @Delete("DELETE FROM posts WHERE id = #{id}")
    int deleteBoardById(Long id);

    @Update("UPDATE posts SET title = #{title}, content = #{content} WHERE id = #{id}")
    int updateBoard(BoardDTO boardDTO);
}
