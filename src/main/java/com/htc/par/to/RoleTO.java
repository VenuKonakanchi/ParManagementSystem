package com.htc.par.to;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RoleTO {
@Positive	
private Integer roleId;
@NotNull(message="Role Name can not be null")	
private String roleName;

public RoleTO() {
	super();
}


public RoleTO(@Positive Integer roleId, @NotNull(message = "Role Name can not be null") String roleName) {
	super();
	this.roleId = roleId;
	this.roleName = roleName;
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


@Override
public String toString() {
	return "RoleTO [roleId=" + roleId + ", roleName=" + roleName + "]";
}



}
