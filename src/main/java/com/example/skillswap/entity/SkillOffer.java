package com.example.skillswap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SkillOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillOfferId;
	private Long memberId;
	private String skillName;
	private String description;
	private String level;
	private Integer creditsRequired;

	public Long getSkillOfferId() { return skillOfferId; }
	public void setSkillOfferId(Long skillOfferId) { this.skillOfferId = skillOfferId; }
	public Long getMemberId() { return memberId; }
	public void setMemberId(Long memberId) { this.memberId = memberId; }
	public String getSkillName() { return skillName; }
	public void setSkillName(String skillName) { this.skillName = skillName; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getLevel() { return level; }
	public void setLevel(String level) { this.level = level; }
	public Integer getCreditsRequired() { return creditsRequired; }
	public void setCreditsRequired(Integer creditsRequired) { this.creditsRequired = creditsRequired; }
}