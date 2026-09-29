package com.example.skillswap.service;

import com.example.skillswap.entity.Member;
import com.example.skillswap.repository.MemberRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberService {
	private final MemberRepository repository;

	public MemberService(MemberRepository repository) {
		this.repository = repository;
	}

	public List<Member> getAll() { return repository.findAll(); }

	public Member getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
	}

	public Member create(Member member) { return repository.save(member); }

	public Member update(Long id, Member member) {
		Member existing = getById(id);
		existing.setName(member.getName());
		existing.setEmail(member.getEmail());
		existing.setPhone(member.getPhone());
		existing.setPassword(member.getPassword());
		return repository.save(existing);
	}

	public void delete(Long id) { repository.delete(getById(id)); }
}