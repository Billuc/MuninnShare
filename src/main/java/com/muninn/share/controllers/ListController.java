package com.muninn.share.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muninn.share.models.List;
import com.muninn.share.repositories.ListRepository;
import com.muninn.share.exceptions.ListNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ListController {
    private final ListRepository listRepository;

    ListController(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @GetMapping("/lists/{id}")
    public List GetList(@PathVariable(name = "id") String id) {
        Optional<List> list = listRepository.findById(id);
        return list.orElseThrow(() -> new ListNotFoundException(id));
    }

    @PostMapping("/lists")
    public List CreateList(@RequestBody List entity) {
        return listRepository.save(entity);
    }

    @PostMapping("/lists/{id}")
    public List UpdateList(@PathVariable(name = "id") String id, @RequestBody List update) {
        return listRepository.save(new List(id, update.getTitle(), update.getHideChecked()));
    }

}
