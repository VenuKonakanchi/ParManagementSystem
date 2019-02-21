package com.htc.par.to;

public class SkillTO {
	
	private Integer skillId;
	private String skillName;
	private Boolean skillActive;
	
	public SkillTO() {
		super();
	}
	
	public SkillTO(String skillName, Boolean skillActive) {
		super();
		this.skillName = skillName;
		this.skillActive = skillActive;
	}

	public SkillTO(int skillId, String skillName, Boolean skillActive) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillActive = skillActive;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Boolean getSkillActive() {
		return skillActive;
	}

	public void setSkillActive(Boolean skillActive) {
		this.skillActive = skillActive;
	}

	@Override
	public String toString() {
		return "SkillTO [skillId=" + skillId + ", skillName=" + skillName + ", skillActive=" + skillActive + "]";
	}

}
