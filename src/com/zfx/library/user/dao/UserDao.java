package com.zfx.library.user.dao;

import java.util.List;

import com.zfx.library.user.bean.User;

public interface UserDao {
	void add(User user);

	void update(User user);

	void delete(User user);

	User findById(Integer id);
	
	User findByName(String name);

	List<User> findAll();
	

}
