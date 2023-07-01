package com.singers.singers.dao;

import com.singers.singers.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
