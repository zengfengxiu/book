package com.zfx.library.reader.dao;

import java.util.List;

import com.zfx.library.reader.bean.Reader;

public interface ReaderDao {
	void add(Reader reader);
	
	void update(Reader reader);
	
	void delete(Reader reader);
	
	Reader findById(Integer id);
	
	Reader findByName(String name);
	
	Reader findByNo(String no);
	
	List<Reader> findAll();
}
