package com.example.demo.controller.board;

import com.example.demo.dto.board.BoardDTO;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("board/boardread")
    public String boardRead(HttpSession session, Model model) {
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            model.addAttribute("error", "회원가입을 해주세요.");
            return "redirect:/user/signup";
        }
        model.addAttribute("loggedInUser", loggedInUser);

        List<BoardDTO> boardList = boardService.getAllBoards();
        model.addAttribute("boardList", boardList);

        return "board/boardread";
    }

    @GetMapping("/board/BoardWriteForm")
    public String boardWriteForm() {
        return "board/BoardWriteForm";
    }

    @PostMapping("/board/BoardWriteForm")
    public String boardWriteFormScuess(@RequestParam String title, @RequestParam String content, HttpSession session, Model model) {
        String author = (String) session.getAttribute("loggedInUser");
        BoardDTO board = new BoardDTO(title, content, author);
        boardService.insertBoard(board);
        return "board/boardread";
    }




}

