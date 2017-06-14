package com.zfx.library.type.service;

import java.util.List;

import com.zfx.library.type.bean.Type;


public interface TypeService {
	void addType(Type type);
	
	void deleteType(Type type);
	
	Type findTypeById(Integer id);
	
	Type findByName(String name);

	List<Type> findAllType();
}
