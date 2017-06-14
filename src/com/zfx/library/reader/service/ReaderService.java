package com.zfx.library.reader.service;

import java.util.List;

import com.zfx.library.reader.bean.Reader;

public interface ReaderService {
	void addReader(Reader reader);

	void updateReader(Reader reader);

	void deleteReader(Reader reader);
	
	Reader findReaderById(Integer id);

	Reader findByName(String name);

	Reader findByNo(String no);

	List<Reader> findAllReader();
}
