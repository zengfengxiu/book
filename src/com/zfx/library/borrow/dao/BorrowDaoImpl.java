package com.zfx.library.borrow.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zfx.library.borrow.bean.Borrow;
import com.zfx.library.borrow.bean.BorrowResult;

@Repository
public class BorrowDaoImpl extends HibernateDaoSupport implements BorrowDao {
	private String hql = "select new com.zfx.library.borrow.bean.BorrowResult"
			+ "(bk.id, bk.no, bk.name, bk.type.id, bk.type.name, bk.price,"
			+ "r.id, r.no, r.name, br.borrowDate, br.returnDate, br.oper)"
			+ " from Borrow br, Book bk, Reader r"
			+ " where br.bookNo=bk.no and br.readerNo=r.no"
			+ " and br.returnDate=null";

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void add(Borrow borrow) {
		this.getHibernateTemplate().save(borrow);
	}

	@Override
	public void update(Borrow borrow) {
		this.getHibernateTemplate().update(borrow);
	}

	@Override
	public void delete(Borrow borrow) {
		this.getHibernateTemplate().delete(borrow);
	}

	@Override
	public Borrow findById(Integer id) {
		return this.getHibernateTemplate().get(Borrow.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Borrow findByBookNoAndReaderNo(String bookNo, String readerNo) {
		List<Borrow> list;
		list = this.getHibernateTemplate().find(
				"from Borrow where bookNo=? and readerNo=?", bookNo, readerNo);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public BorrowResult findResultByBookNoAndReaderNo(String bookNo,
			String readerNo) {
		String hql1 = hql + " and br.bookNo=? and br.readerNo=?";
		List<BorrowResult> list;
		list = this.getHibernateTemplate().find(hql1, bookNo, readerNo);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowResult> findResultByBookNo(String bookNo) {
		String hql1 = hql + " and br.bookNo=?";
		return this.getHibernateTemplate().find(hql1, bookNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowResult> findResultByReaderNo(String readerNo) {
		String hql1 = hql + " and br.readerNo=?";
		return this.getHibernateTemplate().find(hql1, readerNo);
	}
}
