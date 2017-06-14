package com.zfx.library.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zfx.library.book.bean.Book;
import com.zfx.library.book.dao.BookDao;

//服务，用于注解业务逻辑层
@Service
public class BookServiceImpl implements BookService {

	// 依赖资源
	@Resource
	private BookDao bookDao;

	@Override
	public void addBook(Book book) {
		bookDao.add(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.update(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookDao.delete(book);
	}

	@Override
	public Book findBookById(Integer id) {
		return bookDao.findById(id);
	}

	@Override
	public Book findByNo(String no) {
		return bookDao.findByNo(no);
	}

	@Override
	public List<Book> findAllBook() {
		return bookDao.findAll();
	}

	@Override
	public List<Book> findAllBook(int pageNo, int pageSize) {
		return bookDao.findAll(pageNo, pageSize);
	}

	@Override
	public int getTotalPages(int pageSize) {
		return bookDao.getTotalPages(pageSize);
	}

	@Override
	public List<Book> findAllBook(Book condition, int pageNo, int pageSize) {
		return bookDao.findAll(condition, pageNo, pageSize);
	}

	// getter & setter

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
