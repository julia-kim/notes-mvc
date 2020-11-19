package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Note;
import com.example.demo.repository.NoteRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {
	private ArrayList<Note> notes = new ArrayList<>();
	
	@Autowired
	private NoteRepository noteRepository;

	@GetMapping("/")
	public String index(Note note, Model model) {
		model.addAttribute("notes", notes);
		model.addAttribute("title", "My Notes");
		return "index";
	}
	
	private Note note;
	
	@PostMapping("/")
	public String addNewNote(Note note, Model model) {
		noteRepository.save(new Note(note.getContent(), note.getColor(), note.getFont()));
		model.addAttribute("content", note.getContent());
		model.addAttribute("color", note.getColor());
		model.addAttribute("font", note.getFont());
		notes.add(note);
		return "redirect:/";
	}
	
	@GetMapping("/elsewhere")
	public String elsewhere(Model model) {
		model.addAttribute("title", "Never Gonna Give You Up");
		return "elsewhere";
	}
}
