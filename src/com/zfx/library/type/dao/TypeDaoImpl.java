package com.zfx.library.type.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zfx.library.type.bean.Type;



//�ֿ⣬����ע��DAO��
@Repository
//DAO��ͨ���̳���HibernateDaoSupport��
//HibernateDaoSupport���ṩ�˴�������õ����ݲ���
public class TypeDaoImpl extends HibernateDaoSupport implements TypeDao {

	// HibernateDaoSupport��������SessionFactory
	// ��Ҫ�ṩset����������������Դ��ע��
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	
	
	@Override
	public void add(Type type) {
		this.getHibernateTemplate().save(type);

	}

	@Override
	public void delete(Type type) {
		this.getHibernateTemplate().delete(type);

	}

	@Override
	public Type findById(Integer id) {
		return this.getHibernateTemplate().get(Type.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Type findByName(String name) {
		List<Type> list = this.getHibernateTemplate().find(
				"from Type where name=?", name);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findAll() {
		return this.getHibernateTemplate().find("from Type");
	}

}
