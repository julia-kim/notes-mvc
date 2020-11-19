package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
	

}