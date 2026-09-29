package com.example.skillswap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CreditLedger {

	public enum TransactionType { EARN, SPEND }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long creditLedgerId;
	private Long memberId;
	private Long sessionRequestId;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	private Integer credits;
	private LocalDateTime transactionDate;
	private String description;

	public Long getCreditLedgerId() { return creditLedgerId; }
	public void setCreditLedgerId(Long creditLedgerId) { this.creditLedgerId = creditLedgerId; }
	public Long getMemberId() { return memberId; }
	public void setMemberId(Long memberId) { this.memberId = memberId; }
	public Long getSessionRequestId() { return sessionRequestId; }
	public void setSessionRequestId(Long sessionRequestId) { this.sessionRequestId = sessionRequestId; }
	public TransactionType getTransactionType() { return transactionType; }
	public void setTransactionType(TransactionType transactionType) { this.transactionType = transactionType; }
	public Integer getCredits() { return credits; }
	public void setCredits(Integer credits) { this.credits = credits; }
	public LocalDateTime getTransactionDate() { return transactionDate; }
	public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
}