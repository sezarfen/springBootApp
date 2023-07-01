package com.singers.singers.service;

import com.singers.singers.entity.User;
import com.singers.singers.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(WebUser webUser);

}
