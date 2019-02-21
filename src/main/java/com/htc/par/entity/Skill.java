/**
 * 
 */
package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity Class for skill_lkup
 *
 */

@Entity
@Table(name="skill_lkup")
public class Skill {

	
	@Id
	@Column(name="skill_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "skill_seq")
	@SequenceGenerator(name="skill_seq", sequenceName="skill_seq",initialValue = 8000, allocationSize=1)
	private int skillId;
	
	@Column(name="skill_nm")
	private String skillName;
	
	@Column(name="skill_active")
	private boolean isSkillActive;

	public Skill() {
		super();
	}

	public Skill(String skillName, boolean isSkillActive) {
		super();
		this.skillName = skillName;
		this.isSkillActive = isSkillActive;
	}

	public Skill(int skillId, String skillName, boolean isSkillActive) {
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

	public void setSkillActive(boolean skillActive) {
		this.isSkillActive = skillActive;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", skillActive=" + isSkillActive + "]";
	}
	
}
