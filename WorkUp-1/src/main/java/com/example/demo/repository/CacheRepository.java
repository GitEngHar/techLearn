package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.ContentsStatusCacheEntity;

@Mapper
public interface CacheRepository {
	@Select("SELECT * FROM contents_status_root WHERE id = #{id}")
	ContentsStatusCacheEntity getcacheData(int id) ;
	
	@Update("UPDATE contents_status_root SET status={#status} WHERE id = #{id}")
	ContentsStatusCacheEntity setcacheData(int id) ;
}
