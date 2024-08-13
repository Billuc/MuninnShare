package com.muninn.share.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muninn.share.models.Board;
import com.muninn.share.repositories.BoardRepository;
import com.muninn.share.exceptions.BoardNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/boards")
    public Board CreateBoard(@RequestBody Board entity) {
        return boardRepository.save(entity);
    }

    @PostMapping("/boards/{id}")
    public Board UpdateBoard(@PathVariable(name = "id") String id, @RequestBody Board update) {
        return boardRepository.save(new Board(id, update.getTitle(), update.getCards()));
    }

}
