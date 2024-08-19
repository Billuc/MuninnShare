package com.muninn.share.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
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
    public List<ListElement> UpdateAllListElements(
            @PathVariable(name = "id") String listId,
            @RequestBody ListElement[] elements) {
        List<ListElement> currentElements = listElementRepository.findByListId(listId);
        List<ListElement> updatedElements = new ArrayList<ListElement>(elements.length);

        Stream<Object> elementsToDeleteStream = Arrays.stream(currentElements.toArray());

        for (int i = 0; i < elements.length; i++) {
            ListElement currElement = elements[i];

            updatedElements.add(
                    listElementRepository.save(new ListElement(currElement.getId(), currElement.getTitle(),
                            currElement.getDone(), i, currElement.getParentId(), listId)));

            elementsToDeleteStream = elementsToDeleteStream
                    .filter((el) -> ((ListElement) el).getId() != currElement.getId());
        }

        elementsToDeleteStream.forEach((el) -> listElementRepository.delete((ListElement) el));

        return updatedElements;
    }

    @PostMapping("/list-elements")
    public ListElement CreateListElement(@RequestBody ListElement entity) {
        return listElementRepository.save(entity);
    }

    @PostMapping("/list-elements/{id}")
    public ListElement UpdateListElement(@PathVariable(name = "id") String id, @RequestBody ListElement.Update update) {
        ListElement toUpdate = listElementRepository.findById(id).orElseThrow();

        return listElementRepository.save(
                new ListElement(
                        id,
                        update.title().orElse(toUpdate.getTitle()),
                        update.done().orElse(toUpdate.getDone()),
                        toUpdate.getIndex(),
                        toUpdate.getParentId(),
                        toUpdate.getListId()));
    }

    @DeleteMapping("/list-elements/{id}")
    public void DeleteListElement(@PathVariable(name = "id") String id) {
        listElementRepository.deleteById(id);
    }

    @PostMapping("/list-elements/{parentId}/sort")
    public void SortListElements(@PathVariable(name = "parentId") String parentId,
            @RequestBody ListElement[] sortedElements) {
        for (int i = 0; i < sortedElements.length; i++) {
            ListElement currElement = sortedElements[i];

            listElementRepository.save(new ListElement(
                    currElement.getId(),
                    currElement.getTitle(),
                    currElement.getDone(),
                    i,
                    parentId,
                    currElement.getListId()));
        }
    }

}
