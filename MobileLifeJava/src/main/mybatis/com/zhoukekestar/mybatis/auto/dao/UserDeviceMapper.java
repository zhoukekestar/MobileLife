package com.zhoukekestar.mybatis.auto.dao;

import com.zhoukekestar.mybatis.auto.model.UserDevice;
import com.zhoukekestar.mybatis.auto.model.UserDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDeviceMapper {
    int countByExample(UserDeviceExample example);

    int deleteByExample(UserDeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDevice record);

    int insertSelective(UserDevice record);

    List<UserDevice> selectByExample(UserDeviceExample example);

    UserDevice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDevice record, @Param("example") UserDeviceExample example);

    int updateByExample(@Param("record") UserDevice record, @Param("example") UserDeviceExample example);

    int updateByPrimaryKeySelective(UserDevice record);

    int updateByPrimaryKey(UserDevice record);
}