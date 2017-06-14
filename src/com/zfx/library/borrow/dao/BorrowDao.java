package com.zfx.library.borrow.dao;

import java.util.List;

import com.zfx.library.borrow.bean.Borrow;
import com.zfx.library.borrow.bean.BorrowResult;

// 数据访问层
public interface BorrowDao {
	// 增
	void add(Borrow borrow);

	// 改
	void update(Borrow borrow);

	// 删
	void delete(Borrow borrow);

	// 查（ID）
	Borrow findById(Integer id);

	// 查（图书编号+读者编号）
	Borrow findByBookNoAndReaderNo(String bookNo, String readerNo);

	// 查找借书记录（图书编号+读者编号）
	BorrowResult findResultByBookNoAndReaderNo(String bookNo, String readerNo);

	// 查找借书记录（图书编号）
	List<BorrowResult> findResultByBookNo(String bookNo);

	// 查找借书记录（读者编号）
	List<BorrowResult> findResultByReaderNo(String readerNo);
}
