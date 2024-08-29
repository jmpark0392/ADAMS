package com.rds.adams.web.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.core.dao.MybatisTestDao;
import com.rds.adams.web.core.dto.GocInfoDto;

@Service
public class MybatisTestService {
	
	@Autowired
	MybatisTestDao mybatisTestDao;
	
	public List<GocInfoDto> selectList(GocInfoDto inVo) {
		
		return mybatisTestDao.selectList(inVo);
		
	}

}