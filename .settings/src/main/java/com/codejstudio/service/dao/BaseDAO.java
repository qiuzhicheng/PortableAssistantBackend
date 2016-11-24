package com.codejstudio.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.codejstudio.service.util.ResultFilter;

public interface BaseDAO {
	public <T> T get(String u_mobile);
	public <T> int insert(T t);
	public <T> boolean update(T t);
	public <T> List<T> list(ResultFilter<T> rf);
	public <T> int count(T where);
	public boolean delete(@Param("id")Integer id);
}
