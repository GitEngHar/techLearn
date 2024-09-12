package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.JqueryEntity;

@Mapper
public interface JqueryRepository {
	@Select("SELECT * FROM jquery_validate WHERE id = #{id}")
	JqueryEntity getjqData(int id) ;
}
