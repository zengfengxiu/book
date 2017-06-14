package com.zfx.library.borrow.dao;

import java.util.List;

import com.zfx.library.borrow.bean.Borrow;
import com.zfx.library.borrow.bean.BorrowResult;

// ���ݷ��ʲ�
public interface BorrowDao {
	// ��
	void add(Borrow borrow);

	// ��
	void update(Borrow borrow);

	// ɾ
	void delete(Borrow borrow);

	// �飨ID��
	Borrow findById(Integer id);

	// �飨ͼ����+���߱�ţ�
	Borrow findByBookNoAndReaderNo(String bookNo, String readerNo);

	// ���ҽ����¼��ͼ����+���߱�ţ�
	BorrowResult findResultByBookNoAndReaderNo(String bookNo, String readerNo);

	// ���ҽ����¼��ͼ���ţ�
	List<BorrowResult> findResultByBookNo(String bookNo);

	// ���ҽ����¼�����߱�ţ�
	List<BorrowResult> findResultByReaderNo(String readerNo);
}
