package com.example.demo.service;

import com.example.demo.Repository.BoardMapper;
import com.example.demo.dto.board.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<BoardDTO> searchBoards(String keyword) {
        return boardMapper.searchBoards(keyword);
    }

    public int getTotalBoardCount() {
        return boardMapper.countBoards();
    }

    public int getTotalSearchCount(String keyword) {
        return boardMapper.getTotalSearchCount(keyword);
    }

    public List<BoardDTO> getBoardsByPage(int page, int size) {
        if (page < 1) page = 1;
        int offset = (page - 1) * size;
        return boardMapper.getBoardList(size, Math.max(0, offset));
    }

    public List<Integer> getPageNumbers(int totalPages) {
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            pageNumbers.add(i);
        }
        return pageNumbers;
    }
    public List<BoardDTO> searchBoardsByPage(String keyword, int page, int size) {
        int offset = (page - 1) * size;
        return boardMapper.searchBoardsByPage(keyword, size, offset);
    }



}
