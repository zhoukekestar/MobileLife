package com.zhoukekestar.mybatis.auto.dao;

import com.zhoukekestar.mybatis.auto.model.OneModel;
import com.zhoukekestar.mybatis.auto.model.OneModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OneModelMapper {
    int countByExample(OneModelExample example);

    int deleteByExample(OneModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OneModel record);

    int insertSelective(OneModel record);

    List<OneModel> selectByExample(OneModelExample example);

    OneModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OneModel record, @Param("example") OneModelExample example);

    int updateByExample(@Param("record") OneModel record, @Param("example") OneModelExample example);

    int updateByPrimaryKeySelective(OneModel record);

    int updateByPrimaryKey(OneModel record);
}