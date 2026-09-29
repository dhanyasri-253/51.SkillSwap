package com.example.skillswap.controller;

import com.example.skillswap.entity.Member;
import com.example.skillswap.service.MemberService;
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
@RequestMapping("/members")
public class MemberController {
	private final MemberService service;

	public MemberController(MemberService service) { this.service = service; }

	@GetMapping
	public List<Member> getAll() { return service.getAll(); }

	@GetMapping("/{id}")
	public Member getById(@PathVariable Long id) { return service.getById(id); }

	@PostMapping
	public Member create(@RequestBody Member member) { return service.create(member); }

	@PutMapping("/{id}")
	public Member update(@PathVariable Long id, @RequestBody Member member) { return service.update(id, member); }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) { service.delete(id); }
}