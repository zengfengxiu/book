package com.zfx.library.reader.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zfx.library.reader.bean.Reader;
import com.zfx.library.reader.dao.ReaderDao;

//服务，用于注解业务逻辑层
@Service
public class ReaderServiceImpl implements ReaderService {

	// 依赖资源
	@Resource
	private ReaderDao readerDao;	
	
	@Override
	public void addReader(Reader reader) {
		readerDao.add(reader);
	}

	@Override
	public void updateReader(Reader reader) {
		readerDao.update(reader);
	}

	@Override
	public void deleteReader(Reader reader) {
		readerDao.delete(reader);
	}

	@Override
	public Reader findReaderById(Integer id) {		
		return readerDao.findById(id);
	}

	@Override
	public Reader findByName(String name) {
		return readerDao.findByName(name);
	}

	@Override
	public Reader findByNo(String no) {	
		return readerDao.findByNo(no);
	}
	
	@Override
	public List<Reader> findAllReader() {
		return readerDao.findAll();
	}

	
	// getter & setter
	public ReaderDao getReaderDao() {
		return readerDao;
	}

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}
	
}
