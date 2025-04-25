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

    @Select("SELECT * FROM posts WHERE title LIKE CONCAT('%', #{keyword}, '%') ORDER BY created_at DESC")
    List<BoardDTO> searchBoards(String keyword);

    @Select("SELECT COUNT(*) FROM posts")
    int countBoards();

    @Select("SELECT * FROM posts ORDER BY created_at DESC LIMIT #{size} OFFSET #{offset}")
    List<BoardDTO> getBoardList(@Param("size") int size, @Param("offset") int offset);

    @Select("SELECT COUNT(*) FROM posts WHERE title LIKE CONCAT('%', #{keyword}, '%') OR content LIKE CONCAT('%', #{keyword}, '%')")
    int getTotalSearchCount(@Param("keyword") String keyword);

    @Select("SELECT * FROM posts WHERE title LIKE CONCAT('%', #{keyword}, '%') OR content LIKE CONCAT('%', #{keyword}, '%') ORDER BY created_at DESC LIMIT #{size} OFFSET #{offset}")
    List<BoardDTO> searchBoardsByPage(@Param("keyword") String keyword, @Param("size") int size, @Param("offset") int offset);


}
