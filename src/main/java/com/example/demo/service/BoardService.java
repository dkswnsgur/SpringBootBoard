package com.example.demo.service;

import com.example.demo.Repository.BoardMapper;
import com.example.demo.dto.board.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public void insertBoard(BoardDTO board) {
        boardMapper.insertBoard(board);
    }

    public List<BoardDTO> getAllBoards() {
        return boardMapper.getAllBoards();
    }

    public BoardDTO getBoardById(Long id) {
        return boardMapper.getBoardById(id);
    }

    public boolean deleteBoardById(Long id) {
        int delete = boardMapper.deleteBoardById(id);
        return delete > 0;
    }
    public boolean updateBoard(BoardDTO boardDTO) {
        int result = boardMapper.updateBoard(boardDTO);
        return result > 0;
    }
}
