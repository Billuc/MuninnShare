package com.muninn.share.repositories;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.muninn.share.models.Note;

@Repository
public interface NoteRepository extends CosmosRepository<Note, String> {

}
