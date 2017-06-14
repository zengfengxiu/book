package com.zfx.library.type.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zfx.library.type.bean.Type;
import com.zfx.library.type.dao.TypeDao;

//服务，用于注解业务逻辑层
@Service
public class TypeServiceImpl implements TypeService {
	// 依赖资源
	@Resource
	private TypeDao typeDao;
	
	@Override
	public void addType(Type type) {
		typeDao.add(type);
	}

	@Override
	public void deleteType(Type type) {
		typeDao.delete(type);
	}

	@Override
	public Type findTypeById(Integer id) {	
		return typeDao.findById(id);
	}

	@Override
	public Type findByName(String name) {		
		return typeDao.findByName(name);
	}

	@Override
	public List<Type> findAllType() {	
		return typeDao.findAll();
	}

	// getter & setter
	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

}
