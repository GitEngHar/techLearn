package com.example.demo.repository.gametransaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.TransactionObject;


@Mapper
public interface TransactionalRepository {
	/* point情報を取得 */
	@Select("SELECT * FROM plugin_gamepoint_transaction WHERE user_id = #{userId}")
	@Results(
		{	
			@Result(property = "transactionalId", column = "transactional_id"),
			@Result(property = "userId", column = "user_id"),
			@Result(property = "changePoint", column = "change_point"),
			@Result(property = "description", column = "description")
		}
	)
	TransactionObject selectTransactionObject(int userId);
	
	/* pointの取引トランザクション情報を格納 */
	@Insert("INSERT INTO plugin_gamepoint_transaction(user_id,change_point,description) VALUES(#{userId},#{changePoint},#{description})")
	void insertTransactionObject(int userId,int changePoint,String description);
	
}
