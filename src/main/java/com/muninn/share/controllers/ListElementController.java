package com.muninn.share.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muninn.share.models.ListElement;
import com.muninn.share.repositories.ListElementRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ListElementController {
    private final ListElementRepository listElementRepository;

    ListElementController(ListElementRepository listRepository) {
        this.listElementRepository = listRepository;
    }

    @GetMapping("/lists/{id}/elements")
    public List<ListElement> GetAllListElements(@PathVariable(name = "id") String listId) {
        List<ListElement> listElements = listElementRepository.findByListId(listId);
        return listElements;
    }

    @PostMapping("/lists/{id}/elements")
    public List<ListElement> UpdateAllListElements(@PathVariable(name = "id") String listId,
            @RequestBody ListElement[] elements) {
        List<ListElement> updatedElements = new ArrayList<ListElement>(elements.length);

        for (int i = 0; i < elements.length; i++) {
            ListElement currElement = elements[i];

            updatedElements.add(
                    listElementRepository.save(new ListElement(currElement.getId(), currElement.getTitle(),
                            currElement.getDone(), i, currElement.getParentId(), listId)));
        }

        return updatedElements;
    }

    @PostMapping("/list-elements")
    public ListElement CreateListElement(@RequestBody ListElement entity) {
        return listElementRepository.save(entity);
    }

    @PostMapping("/list-elements/{id}")
    public ListElement UpdateList(@PathVariable(name = "id") String id, @RequestBody ListElement update) {
        return listElementRepository.save(new ListElement(id, update.getTitle(), update.getDone(), update.getIndex(),
                update.getParentId(), update.getListId()));
    }

}
