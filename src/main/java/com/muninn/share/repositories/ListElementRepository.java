package com.muninn.share.repositories;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.muninn.share.models.ListElement;
import java.util.List;

@Repository
public interface ListElementRepository extends CosmosRepository<ListElement, String> {
    List<ListElement> findByListId(String listId);

    void deleteByListId(String listId);
}
