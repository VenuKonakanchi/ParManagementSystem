package com.htc.par.to;

public class PARRoleTO {
	
	private Integer roleId;
	private String roleName;
	private Boolean RoleActive;
	
	public PARRoleTO() {}

	public PARRoleTO(Integer roleId, String roleName, Boolean roleActive) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		RoleActive = roleActive;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getRoleActive() {
		return RoleActive;
	}

	public void setRoleActive(Boolean roleActive) {
		RoleActive = roleActive;
	}

	@Override
	public String toString() {
		return "PARRoleTO [roleId=" + roleId + ", roleName=" + roleName + ", RoleActive=" + RoleActive + "]";
	}

	
	

}
