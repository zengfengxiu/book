package com.zfx.library.borrow.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zfx.library.borrow.bean.Borrow;
import com.zfx.library.borrow.bean.BorrowResult;
import com.zfx.library.borrow.dao.BorrowDao;

@Service
public class BorrowServiceImpl implements BorrowService {
	@Resource
	private BorrowDao borrowDao;

	@Override
	public void addBorrow(Borrow borrow) {
		borrowDao.add(borrow);
	}

	@Override
	public void addReturn(Borrow borrow) {
		borrowDao.update(borrow);
	}

	@Override
	public void addRenew(Borrow oldBorrow, Borrow newBorrow) {
		borrowDao.update(oldBorrow);
		borrowDao.add(newBorrow);
	}

	@Override
	public Borrow findBorrowByBookNoAndReaderNo(String bookNo, String readerNo) {
		return borrowDao.findByBookNoAndReaderNo(bookNo, readerNo);
	}

	@Override
	public BorrowResult findBorrowResultByBookNoAndReaderNo(String bookNo,
			String readerNo) {
		return borrowDao.findResultByBookNoAndReaderNo(bookNo, readerNo);
	}

	@Override
	public List<BorrowResult> findBorrowResultByBookNo(String bookNo) {
		return borrowDao.findResultByBookNo(bookNo);
	}

	@Override
	public List<BorrowResult> findBorrowResultByReaderNo(String readerNo) {
		return borrowDao.findResultByReaderNo(readerNo);
	}

	// getter & setter

	public BorrowDao getBorrowDao() {
		return borrowDao;
	}

	public void setBorrowDao(BorrowDao borrowDao) {
		this.borrowDao = borrowDao;
	}
}
