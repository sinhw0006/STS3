package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.dao.MemoDao;
import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

@Service
public class MemoService {
//	@Autowired
//	private MemoDao memoDao;
//	
//	public boolean registrationMemo(MemoDto memoDto) throws Exception{
//		int result = memoDao.insert(memoDto);
//		
//		return result > 0;
//	}
	
	@Autowired
	private MemoMapper memoMapper;
	public boolean registrationMemo(MemoDto memoDto) throws Exception{
		int result = memoMapper.insert(memoDto);
		return result > 0;
	}
	
}
