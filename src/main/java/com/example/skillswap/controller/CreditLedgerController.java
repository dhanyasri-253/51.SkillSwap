package com.example.skillswap.controller;

import com.example.skillswap.entity.CreditLedger;
import com.example.skillswap.service.CreditLedgerService;
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
@RequestMapping("/creditledger")
public class CreditLedgerController {
	private final CreditLedgerService service;

	public CreditLedgerController(CreditLedgerService service) { this.service = service; }

	@GetMapping
	public List<CreditLedger> getAll() { return service.getAll(); }

	@GetMapping("/{id}")
	public CreditLedger getById(@PathVariable Long id) { return service.getById(id); }

	@PostMapping
	public CreditLedger create(@RequestBody CreditLedger transaction) { return service.create(transaction); }

	@PutMapping("/{id}")
	public CreditLedger update(@PathVariable Long id, @RequestBody CreditLedger transaction) {
		return service.update(id, transaction);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) { service.delete(id); }
}