package com.zfx.library.reader.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zfx.library.reader.bean.Reader;

//仓库，用于注解DAO类
@Repository
//DAO类通常继承自HibernateDaoSupport类
//HibernateDaoSupport类提供了大多数常用的数据操作
public class ReaderDaoImpl extends HibernateDaoSupport implements ReaderDao {
	// HibernateDaoSupport类依赖于SessionFactory
	// 需要提供set方法并加上依赖资源的注解
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	
	@Override
	public void add(Reader reader) {
		this.getHibernateTemplate().save(reader);
	}

	@Override
	public void update(Reader reader) {
		this.getHibernateTemplate().update(reader);

	}

	@Override
	public void delete(Reader reader) {
		this.getHibernateTemplate().delete(reader);

	}

	@Override
	public Reader findById(Integer id) {	
		return this.getHibernateTemplate().get(Reader.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Reader findByNo(String no) {
		List<Reader> list = this.getHibernateTemplate().find(
				"from Reader where no=?", no);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Reader findByName(String name) {
		return this.getHibernateTemplate().get(Reader.class, name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reader> findAll() {
		return this.getHibernateTemplate().find("from Reader");
	}

	
	}


