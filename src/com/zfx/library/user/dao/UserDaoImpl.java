package com.zfx.library.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zfx.library.user.bean.User;

// 仓库，用于注解DAO类
@Repository
// DAO类通常继承自HibernateDaoSupport类
// HibernateDaoSupport类提供了大多数常用的数据操作
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	// HibernateDaoSupport类依赖于SessionFactory
	// 需要提供set方法并加上依赖资源的注解
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public User findById(Integer id) {
		return this.getHibernateTemplate().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByName(String name) {
		List<User> list = this.getHibernateTemplate().find(
				"from User where name=?", name);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return this.getHibernateTemplate().find("from User");
	}

}
