package com.zfx.library.user.service;

import java.util.List;

import com.zfx.library.user.bean.User;

public interface UserService {
	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	User findUserById(Integer id);
	
	User findByName(String name);

	List<User> findAllUser();
	
	boolean validate(User user);

}
