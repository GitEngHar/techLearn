package com.example.demo.repository.gametransaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.GamePoint;


@Mapper
public interface GamePointRepository {
	/* point情報を取得 */
	@Select("SELECT * FROM root_gamepoint WHERE user_id = #{userId}")
	@Results(
		{	
			@Result(property = "userId", column = "user_id"),
			@Result(property = "point", column = "point"),
		}
	)
	GamePoint selectGamePoint(int userId);
	
	/* pointを更新 */
	@Update("UPDATE root_gamepoint SET point= point - #{exhangeCost} WHERE user_id = #{userId}")
	void exchangePointToItem(int userId,int exhangeCost);
	
	/* pointをリセット */
	@Update("UPDATE root_gamepoint SET point= 100 WHERE user_id = #{userId}")
	void resetPoint(int userId);
}
