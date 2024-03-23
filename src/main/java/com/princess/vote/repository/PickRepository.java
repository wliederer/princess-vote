package com.princess.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.princess.vote.model.Pick;

public interface PickRepository extends JpaRepository<Pick,Long> {

}
