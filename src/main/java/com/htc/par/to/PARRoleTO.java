package com.htc.par.to;

public class PARRoleTO {
	
	private int roleId;
	private String roleName;
	
	public PARRoleTO() {}

	public PARRoleTO(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "PARRoleTO [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	

}
