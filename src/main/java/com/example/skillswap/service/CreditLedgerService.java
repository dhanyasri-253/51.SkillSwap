package com.example.skillswap.service;

import com.example.skillswap.entity.CreditLedger;
import com.example.skillswap.repository.CreditLedgerRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreditLedgerService {
	private final CreditLedgerRepository repository;

	public CreditLedgerService(CreditLedgerRepository repository) {
		this.repository = repository;
	}

	public List<CreditLedger> getAll() { return repository.findAll(); }

	public CreditLedger getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit transaction not found"));
	}

	public CreditLedger create(CreditLedger transaction) { return repository.save(transaction); }

	public CreditLedger update(Long id, CreditLedger transaction) {
		CreditLedger existing = getById(id);
		existing.setMemberId(transaction.getMemberId());
		existing.setSessionRequestId(transaction.getSessionRequestId());
		existing.setTransactionType(transaction.getTransactionType());
		existing.setCredits(transaction.getCredits());
		existing.setTransactionDate(transaction.getTransactionDate());
		existing.setDescription(transaction.getDescription());
		return repository.save(existing);
	}

	public void delete(Long id) { repository.delete(getById(id)); }
}