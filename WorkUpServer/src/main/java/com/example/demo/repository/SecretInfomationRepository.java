package com.example.demo.repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.SecretInfomation;


@Mapper
public interface SecretInfomationRepository {
	/* beantest情報を取得 */
	@Select("SELECT * FROM root_secret_infomation WHERE id = #{id}")
	@Results(
		{	
			@Result(property = "id", column = "id"),
			@Result(property = "info", column = "info"),
		}
	)
	SecretInfomation selectInfomationById(int id);
}