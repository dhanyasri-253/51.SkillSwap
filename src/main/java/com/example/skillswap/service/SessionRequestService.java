package com.example.skillswap.service;

import com.example.skillswap.entity.SessionRequest;
import com.example.skillswap.repository.SessionRequestRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SessionRequestService {
	private final SessionRequestRepository repository;

	public SessionRequestService(SessionRequestRepository repository) {
		this.repository = repository;
	}

	public List<SessionRequest> getAll() { return repository.findAll(); }

	public SessionRequest getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session request not found"));
	}

	public SessionRequest create(SessionRequest request) { return repository.save(request); }

	public SessionRequest update(Long id, SessionRequest request) {
		SessionRequest existing = getById(id);
		existing.setRequesterId(request.getRequesterId());
		existing.setSkillOfferId(request.getSkillOfferId());
		existing.setRequestDate(request.getRequestDate());
		existing.setStatus(request.getStatus());
		existing.setSessionDate(request.getSessionDate());
		return repository.save(existing);
	}

	public void delete(Long id) { repository.delete(getById(id)); }
}