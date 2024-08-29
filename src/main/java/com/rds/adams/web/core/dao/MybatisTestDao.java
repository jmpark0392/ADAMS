package com.rds.adams.web.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.core.dto.GocInfoDto;

@Mapper
public interface MybatisTestDao {
	
	public List<GocInfoDto> selectList(GocInfoDto inVo);

}