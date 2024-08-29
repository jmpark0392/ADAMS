package com.rds.adams.web.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.core.dto.SearchTxtDto;
import com.rds.adams.web.core.dto.UplFileDto;

@Mapper
public interface FileMntDao {
	
	public List<UplFileDto> selectList(SearchTxtDto inVo);

}