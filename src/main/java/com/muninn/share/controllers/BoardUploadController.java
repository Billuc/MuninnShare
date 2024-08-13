package com.muninn.share.controllers;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.muninn.share.models.Board;
import com.muninn.share.models.FullBoard;
import com.muninn.share.models.FullList;
import com.muninn.share.models.Note;
import com.muninn.share.repositories.BoardRepository;
import com.muninn.share.repositories.ListElementRepository;
import com.muninn.share.repositories.ListRepository;
import com.muninn.share.repositories.NoteRepository;

@RestController
public class BoardUploadController {

    private final BoardRepository boardRepository;
    private final ListRepository listRepository;
    private final NoteRepository noteRepository;
    private final ListElementRepository listElementRepository;

    BoardUploadController(BoardRepository boardRepository, ListRepository listRepository, NoteRepository noteRepository,
            ListElementRepository listElementRepository) {
        this.boardRepository = boardRepository;
        this.listRepository = listRepository;
        this.noteRepository = noteRepository;
        this.listElementRepository = listElementRepository;
    }

    @PostMapping("/boards/upload")
    public Board UploadBoard(@RequestBody FullBoard fullBoard) {
        // We could save everything at once with saveAll by extracting the elements in
        // their own array
        for (FullList list : fullBoard.lists()) {
            listRepository.save(list.list());
            listElementRepository.saveAll(Arrays.asList(list.elements()));
        }

        for (Note note : fullBoard.notes()) {
            noteRepository.save(note);
        }

        Board board = boardRepository.save(fullBoard.board());

        return board;
    }
}
