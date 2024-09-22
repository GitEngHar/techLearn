package com.example.demo.repository;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.User;

@Mapper
public interface UserRepository {
	/* beantest情報を取得 */
	@Select("SELECT * FROM users WHERE email = #{email}")
	@Results(
		{	
			@Result(property = "id", column = "id"),
			@Result(property = "email", column = "email"),
			@Result(property = "password", column = "password"),
			@Result(property = "name", column = "name"),
			@Result(property = "roles", column = "roles"),
		}
	)
	Optional<User> selectByEmail(String email);
}
