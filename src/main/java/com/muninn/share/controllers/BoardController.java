package com.muninn.share.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muninn.share.models.Board;
import com.muninn.share.repositories.BoardRepository;
import com.muninn.share.exceptions.BoardNotFoundException;

@RestController
public class BoardController {
    private final BoardRepository boardRepository;

    BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/boards/{id}")
    public Board GetBoard(@PathVariable(name = "id") String id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.orElseThrow(() -> new BoardNotFoundException(id));
    }
}
