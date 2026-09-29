package com.example.skillswap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class SessionRequest {

	public enum Status { PENDING, ACCEPTED, REJECTED, COMPLETED }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sessionRequestId;
	private Long requesterId;
	private Long skillOfferId;
	private LocalDate requestDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	private LocalDate sessionDate;

	public Long getSessionRequestId() { return sessionRequestId; }
	public void setSessionRequestId(Long sessionRequestId) { this.sessionRequestId = sessionRequestId; }
	public Long getRequesterId() { return requesterId; }
	public void setRequesterId(Long requesterId) { this.requesterId = requesterId; }
	public Long getSkillOfferId() { return skillOfferId; }
	public void setSkillOfferId(Long skillOfferId) { this.skillOfferId = skillOfferId; }
	public LocalDate getRequestDate() { return requestDate; }
	public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
	public Status getStatus() { return status; }
	public void setStatus(Status status) { this.status = status; }
	public LocalDate getSessionDate() { return sessionDate; }
	public void setSessionDate(LocalDate sessionDate) { this.sessionDate = sessionDate; }
}