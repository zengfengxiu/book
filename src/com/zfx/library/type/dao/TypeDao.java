package com.zfx.library.type.dao;

import java.util.List;

import com.zfx.library.type.bean.Type;

public interface TypeDao {
	void add(Type type);
	
	void delete(Type type);
	
	Type findById(Integer id);
	
	Type findByName(String name);

	List<Type> findAll();
}
