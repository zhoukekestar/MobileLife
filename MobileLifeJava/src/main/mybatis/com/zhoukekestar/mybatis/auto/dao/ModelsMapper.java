package com.zhoukekestar.mybatis.auto.dao;

import com.zhoukekestar.mybatis.auto.model.Models;
import com.zhoukekestar.mybatis.auto.model.ModelsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelsMapper {
    int countByExample(ModelsExample example);

    int deleteByExample(ModelsExample example);

    int deleteByPrimaryKey(Integer modelId);

    int insert(Models record);

    int insertSelective(Models record);

    List<Models> selectByExample(ModelsExample example);

    Models selectByPrimaryKey(Integer modelId);

    int updateByExampleSelective(@Param("record") Models record, @Param("example") ModelsExample example);

    int updateByExample(@Param("record") Models record, @Param("example") ModelsExample example);

    int updateByPrimaryKeySelective(Models record);

    int updateByPrimaryKey(Models record);
}