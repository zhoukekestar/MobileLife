package com.zhoukekestar.mybatis.auto.dao;

import com.zhoukekestar.mybatis.auto.model.Modules;
import com.zhoukekestar.mybatis.auto.model.ModulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModulesMapper {
    int countByExample(ModulesExample example);

    int deleteByExample(ModulesExample example);

    int deleteByPrimaryKey(Integer moduleId);

    int insert(Modules record);

    int insertSelective(Modules record);

    List<Modules> selectByExample(ModulesExample example);

    Modules selectByPrimaryKey(Integer moduleId);

    int updateByExampleSelective(@Param("record") Modules record, @Param("example") ModulesExample example);

    int updateByExample(@Param("record") Modules record, @Param("example") ModulesExample example);

    int updateByPrimaryKeySelective(Modules record);

    int updateByPrimaryKey(Modules record);
}