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
}
