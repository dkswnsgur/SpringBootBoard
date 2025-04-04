package com.example.demo.controller.board;

import com.example.demo.dto.board.BoardDTO;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/boardread")
    public String boardRead(@RequestParam(value = "page", required = false) Integer currentPage, Model model, HttpSession session) {
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "회원가입을 해주세요.");
            return "redirect:/";
        }
        model.addAttribute("loggedInUser", loggedInUser);

        int pageSize = 10;
        int totalBoardCount = boardService.getTotalBoardCount();
        int totalPages = (int) Math.ceil((double) totalBoardCount / pageSize);

        if (currentPage == null || currentPage < 1) {
            currentPage = 1;
        }
        if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        List<BoardDTO> boardList = boardService.getBoardsByPage(currentPage, pageSize);
        List<Integer> pageNumbers = boardService.getPageNumbers(totalPages);

        model.addAttribute("boardList", boardList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageNumbers", pageNumbers);

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
        return "redirect:/board/boardread";
    }

    @GetMapping("/board/writeFormread/{id}")
    public String writeFormread(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.getBoardById(id);
        model.addAttribute("board", boardDTO);

        return "board/writeFormread";
    }

    @GetMapping("/board/boarddelete/{id}")
    public String boardDelete(@PathVariable Long id) {
        boolean delete = boardService.deleteBoardById(id);
        if (delete) {
            return "redirect:/board/boardread";
        } else {
            return "삭제 오류 입니다";
        }
    }

    @PostMapping("/board/boardupdate")
    public String boardUpdate(BoardDTO boardDTO) {
        boolean update = boardService.updateBoard(boardDTO);
        if (update) {
            return "redirect:/board/boardread";
        } else {
            return "수정 오류";
        }
    }

    @GetMapping("/board/search")
    public String searchBoard(@RequestParam("keyword") String keyword,
                              @RequestParam(value = "page", required = false, defaultValue = "1") int currentPage,
                              HttpSession session, Model model) {

        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            model.addAttribute("error", "회원가입을 해주세요.");
            return "redirect:/";
        }
        model.addAttribute("loggedInUser", loggedInUser);

        int pageSize = 10;
        int totalSearchCount = boardService.getTotalSearchCount(keyword);
        int totalPages = (int) Math.ceil((double) totalSearchCount / pageSize);

        if (currentPage < 1) currentPage = 1;
        if (currentPage > totalPages) currentPage = totalPages;

        List<BoardDTO> searchResults = boardService.searchBoardsByPage(keyword, currentPage, pageSize);
        List<Integer> pageNumbers = boardService.getPageNumbers(totalPages);

        model.addAttribute("boardList", searchResults);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("keyword", keyword);

        return "board/boardread";
    }
}