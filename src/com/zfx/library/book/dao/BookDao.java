package com.zfx.library.book.dao;

import java.util.List;

import com.zfx.library.book.bean.Book;


public interface BookDao {
	void add(Book book);

	void update(Book book);

	void delete(Book book);

	Book findById(Integer id);
	
	Book findByNo(String no);
	
	List<Book> findAll();
	
	List<Book> findAll(int pageNo, int pageSize);
	
	List<Book> findAll(Book condition, int pageNo, int pageSize);

	int getTotalPages(int pageSize);
}
