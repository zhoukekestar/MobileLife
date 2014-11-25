package com.zhoukekestar.mybatis.auto.dao;

import com.zhoukekestar.mybatis.auto.model.LedLog;
import com.zhoukekestar.mybatis.auto.model.LedLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LedLogMapper {
    int countByExample(LedLogExample example);

    int deleteByExample(LedLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LedLog record);

    int insertSelective(LedLog record);

    List<LedLog> selectByExample(LedLogExample example);

    LedLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LedLog record, @Param("example") LedLogExample example);

    int updateByExample(@Param("record") LedLog record, @Param("example") LedLogExample example);

    int updateByPrimaryKeySelective(LedLog record);

    int updateByPrimaryKey(LedLog record);
}