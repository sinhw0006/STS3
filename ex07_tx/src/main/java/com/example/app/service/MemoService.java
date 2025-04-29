package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemoService {
	
	
	@Autowired
	private MemoMapper memomapper;
	
	//전체메모가져오기
	public List<MemoDto> getAllMemo(){
		log.info("MemoService's getAllMemo Call! ");
		return  memomapper.selectAll(); 
	}
	//메모작성
	public void addMemo(MemoDto dto) {
		log.info("MemoService's addMemo Call! ");
		memomapper.insert(dto);
	}	
	
	//메모작성 
	@Transactional(rollbackFor = Exception.class) 
	public void addMemoTx(MemoDto dto)	 {
		log.info("MemoService's addMemoTx Call! ");
		int id=dto.getId();
		memomapper.insert(dto);	//01 정상INSERT 
		dto.setId(id);		//PK오류 발생예정인 dto
		memomapper.insert(dto);	//02	PK오류 발생!!		
	}		
}

