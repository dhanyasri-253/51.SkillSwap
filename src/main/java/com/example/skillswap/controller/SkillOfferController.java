package com.example.skillswap.controller;

import com.example.skillswap.entity.SkillOffer;
import com.example.skillswap.service.SkillOfferService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skilloffers")
public class SkillOfferController {
	private final SkillOfferService service;

	public SkillOfferController(SkillOfferService service) { this.service = service; }

	@GetMapping
	public List<SkillOffer> getAll() { return service.getAll(); }

	@GetMapping("/{id}")
	public SkillOffer getById(@PathVariable Long id) { return service.getById(id); }

	@PostMapping
	public SkillOffer create(@RequestBody SkillOffer offer) { return service.create(offer); }

	@PutMapping("/{id}")
	public SkillOffer update(@PathVariable Long id, @RequestBody SkillOffer offer) { return service.update(id, offer); }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) { service.delete(id); }
}