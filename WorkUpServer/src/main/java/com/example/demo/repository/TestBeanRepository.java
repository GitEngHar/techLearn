package com.example.demo.repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.TestBean;


@Mapper
public interface TestBeanRepository {
	/* beantest情報を取得 */
	@Select("SELECT * FROM root_bean WHERE id = #{id}")
	@Results(
		{	
			@Result(property = "id", column = "id"),
			@Result(property = "beantext", column = "beantext"),
		}
	)
	TestBean selectTestBean(int id);
}
