package com.example.skillswap.controller;

import com.example.skillswap.entity.SessionRequest;
import com.example.skillswap.service.SessionRequestService;
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
@RequestMapping("/sessionrequests")
public class SessionRequestController {
	private final SessionRequestService service;

	public SessionRequestController(SessionRequestService service) { this.service = service; }

	@GetMapping
	public List<SessionRequest> getAll() { return service.getAll(); }

	@GetMapping("/{id}")
	public SessionRequest getById(@PathVariable Long id) { return service.getById(id); }

	@PostMapping
	public SessionRequest create(@RequestBody SessionRequest request) { return service.create(request); }

	@PutMapping("/{id}")
	public SessionRequest update(@PathVariable Long id, @RequestBody SessionRequest request) {
		return service.update(id, request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) { service.delete(id); }
}