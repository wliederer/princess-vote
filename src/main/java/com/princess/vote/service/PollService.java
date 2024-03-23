package com.princess.vote.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.princess.vote.model.Pick;
import com.princess.vote.model.Poll;
import com.princess.vote.repository.PickRepository;
import com.princess.vote.repository.PollRepository;

import jakarta.transaction.Transactional;

@Service
public class PollService {
	
	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	PickRepository pickRepository;
	
	@Transactional
	public Poll insertPoll(Poll poll) {
		Poll p = pollRepository.save(poll);
		
		List<Pick> picks = new ArrayList<>();
		
		p.getPicks().stream().forEach(pick->{
			pick.setPoll(p);
			picks.add(pick);
		});
		
		pickRepository.saveAll(picks);
		
		return p;
	}
	
	public List<Poll> getAllPolls() {
		return pollRepository.findAll();
	}
	
	public Optional<Poll> getByUrl(String url) {
		return pollRepository.findByUrl(url);
	}

}
