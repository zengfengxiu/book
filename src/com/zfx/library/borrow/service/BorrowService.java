package com.zfx.library.borrow.service;

import java.util.List;

import com.zfx.library.borrow.bean.Borrow;
import com.zfx.library.borrow.bean.BorrowResult;

// 业务逻辑层
public interface BorrowService {
	// 借书
	void addBorrow(Borrow borrow);

	// 还书
	void addReturn(Borrow borrow);

	// 续借
	void addRenew(Borrow oldBorrow, Borrow newBorrow);

	// 查（图书编号+读者编号）
	Borrow findBorrowByBookNoAndReaderNo(String bookNo, String readerNo);

	// 查找借书记录（图书编号+读者编号）
	BorrowResult findBorrowResultByBookNoAndReaderNo(String bookNo,
			String readerNo);

	// 查找借书记录（图书编号）
	List<BorrowResult> findBorrowResultByBookNo(String bookNo);

	// 查找借书记录（读者编号）
	List<BorrowResult> findBorrowResultByReaderNo(String readerNo);
}
