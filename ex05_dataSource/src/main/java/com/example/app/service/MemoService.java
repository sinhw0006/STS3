package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.dao.MemoDao;
import com.example.app.domain.dto.MemoDto;

@Service
public class MemoService {
	@Autowired
	private MemoDao memoDao;
	
	public boolean registrationMemo(MemoDto memoDto) throws Exception{
		int result = memoDao.insert(memoDto);
		
		return result > 0;
	}
}
