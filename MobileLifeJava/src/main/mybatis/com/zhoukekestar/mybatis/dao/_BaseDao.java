package com.zhoukekestar.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface _BaseDao<T, T2> {
	
	int countByExample(T2 example);

    int deleteByExample(T2 example);

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExampleWithBLOBs(T2 example);

    List<T> selectByExample(T2 example);

    T selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") T2 example);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") T2 example);

    int updateByExample(@Param("record") T record, @Param("example") T2 example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}
