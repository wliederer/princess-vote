package com.princess.vote.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@NoArgsConstructor
@ToString(exclude="poll")
public class Pick {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String option;
	@ManyToOne
	@JoinColumn(name="poll_id")
	private Poll poll;
	@OneToMany(mappedBy="pick",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PersonPick> personPicks;
	
	
	public Long getId() {
		return id;
	}
	public String getOption() {
		return option;
	}
	
	public List<PersonPick> getPersonPicks() {
		return personPicks;
	}
	
	
}
