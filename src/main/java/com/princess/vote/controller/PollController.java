package com.princess.vote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.princess.vote.model.Poll;
import com.princess.vote.service.PollService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/polls")
@Validated
public class PollController {
	
	@Autowired
	PollService pollService;
	
	@PostMapping
	public ResponseEntity<Poll> insertPoll(@Valid @RequestBody Poll poll) {
		Poll p = pollService.insertPoll(poll);
		
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Poll>> getAllPolls(){
		List<Poll> polls = pollService.getAllPolls();
		return new ResponseEntity<>(polls,HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<?> getByUrl(@RequestParam String url) {
		Optional<Poll> p = pollService.getByUrl(url);
		if(p.isPresent()) {
			return new ResponseEntity<>(p.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
