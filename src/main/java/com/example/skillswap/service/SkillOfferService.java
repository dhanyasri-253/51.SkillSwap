package com.example.skillswap.service;

import com.example.skillswap.entity.SkillOffer;
import com.example.skillswap.repository.SkillOfferRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SkillOfferService {
	private final SkillOfferRepository repository;

	public SkillOfferService(SkillOfferRepository repository) {
		this.repository = repository;
	}

	public List<SkillOffer> getAll() { return repository.findAll(); }

	public SkillOffer getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill offer not found"));
	}

	public SkillOffer create(SkillOffer offer) { return repository.save(offer); }

	public SkillOffer update(Long id, SkillOffer offer) {
		SkillOffer existing = getById(id);
		existing.setMemberId(offer.getMemberId());
		existing.setSkillName(offer.getSkillName());
		existing.setDescription(offer.getDescription());
		existing.setLevel(offer.getLevel());
		existing.setCreditsRequired(offer.getCreditsRequired());
		return repository.save(existing);
	}

	public void delete(Long id) { repository.delete(getById(id)); }
}