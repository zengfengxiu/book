package com.zfx.library.book.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zfx.library.book.bean.Book;

//仓库，用于注解DAO类
@Repository
// DAO类通常继承自HibernateDaoSupport类
// HibernateDaoSupport类提供了大多数常用的数据操作
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {
	// HibernateDaoSupport类依赖于SessionFactory
	// 需要提供set方法并加上依赖资源的注解
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void add(Book book) {
		this.getHibernateTemplate().save(book);
	}

	@Override
	public void update(Book book) {
		this.getHibernateTemplate().update(book);
	}

	@Override
	public void delete(Book book) {
		this.getHibernateTemplate().delete(book);
	}

	@Override
	public Book findById(Integer id) {
		return this.getHibernateTemplate().get(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Book findByNo(String no) {
		List<Book> list;
		list = this.getHibernateTemplate().find("from Book where no=?", no);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		return this.getHibernateTemplate().find("from Book");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Book> findAll(final int pageNo, final int pageSize) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Query query = session.createQuery("from Book");
						query.setFirstResult((pageNo - 1) * pageSize);
						query.setMaxResults(pageSize);
						List list = query.list();
						return list;

					}
				});
		return list;
	}

	@Override
	public int getTotalPages(int pageSize) {
		int recordSize = ((Number) this.getHibernateTemplate()
				.find("select count(*) from Book").listIterator().next())
				.intValue();
		return (recordSize + (pageSize - 1)) / pageSize;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Book> findAll(final Book condition, final int pageNo,
			final int pageSize) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						List result = null;

						Criteria criteria = session.createCriteria(Book.class);

						// 5个查询条件
						criteria.add(Restrictions.like("no",
								"%" + condition.getNo() + "%"));

						criteria.add(Restrictions.like("name",
								"%" + condition.getName() + "%"));

						if (condition.getType().getId() != 0) {
							criteria.add(Restrictions.eq("type.id", condition
									.getType().getId()));
						}

						criteria.add(Restrictions.like("publisher", "%"
								+ condition.getPublisher() + "%"));

						criteria.add(Restrictions.like("author", "%"
								+ condition.getAuthor() + "%"));

						// 分页设定
						criteria.setFirstResult((pageNo - 1) * pageSize);
					    criteria.setMaxResults(pageSize);

						result = criteria.list();

						return result;

					}
				});
		return list;
	}
}
