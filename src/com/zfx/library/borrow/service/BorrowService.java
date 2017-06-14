package com.zfx.library.borrow.service;

import java.util.List;

import com.zfx.library.borrow.bean.Borrow;
import com.zfx.library.borrow.bean.BorrowResult;

// ҵ���߼���
public interface BorrowService {
	// ����
	void addBorrow(Borrow borrow);

	// ����
	void addReturn(Borrow borrow);

	// ����
	void addRenew(Borrow oldBorrow, Borrow newBorrow);

	// �飨ͼ����+���߱�ţ�
	Borrow findBorrowByBookNoAndReaderNo(String bookNo, String readerNo);

	// ���ҽ����¼��ͼ����+���߱�ţ�
	BorrowResult findBorrowResultByBookNoAndReaderNo(String bookNo,
			String readerNo);

	// ���ҽ����¼��ͼ���ţ�
	List<BorrowResult> findBorrowResultByBookNo(String bookNo);

	// ���ҽ����¼�����߱�ţ�
	List<BorrowResult> findBorrowResultByReaderNo(String readerNo);
}
