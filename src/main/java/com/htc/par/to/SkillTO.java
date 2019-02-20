package com.htc.par.to;

public class SkillTO {
	
	private int skillId;
	private String skillName;
	private boolean isSkillActive;
	
	public SkillTO() {
		super();
	}
	
	public SkillTO(String skillName, boolean isSkillActive) {
		super();
		this.skillName = skillName;
		this.isSkillActive = isSkillActive;
	}

	public SkillTO(int skillId, String skillName, boolean isSkillActive) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.isSkillActive = isSkillActive;
	}


	public int getSkillId() {
		return skillId;
	}
	
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	
	public String getSkillName() {
		return skillName;
	}
	
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public boolean isSkillActive() {
		return isSkillActive;
	}

	public void setSkillActive(boolean isSkillActive) {
		this.isSkillActive = isSkillActive;
	}

	@Override
	public String toString() {
		return "SkillTO [skillId=" + skillId + ", skillName=" + skillName + ", skillActive=" + isSkillActive + "]";
	}	

}
