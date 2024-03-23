package com.princess.vote.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.princess.vote.model.Poll;

public interface PollRepository extends JpaRepository<Poll,Long> {

	Optional<Poll> findByUrl(String url);
	
}
