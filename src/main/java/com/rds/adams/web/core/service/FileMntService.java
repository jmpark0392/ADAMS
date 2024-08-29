package com.rds.adams.web.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.core.dao.FileMntDao;
import com.rds.adams.web.core.dto.SearchTxtDto;
import com.rds.adams.web.core.dto.UplFileDto;

@Service
public class FileMntService {
	
	@Autowired
	FileMntDao filemntdao;
	
	public List<UplFileDto> selectList(SearchTxtDto inVo) {
		
		return filemntdao.selectList(inVo);
		
	}

}