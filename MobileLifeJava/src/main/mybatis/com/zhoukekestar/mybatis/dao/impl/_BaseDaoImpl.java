package com.zhoukekestar.mybatis.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.zhoukekestar.mybatis.dao._BaseDao;
import com.zhoukekestar.mybatis.utils.DBUtils;

public class _BaseDaoImpl<T, T2> implements _BaseDao<T, T2> {
	
	protected SqlSession session = DBUtils.getSession();
	private String className;
	static private Map<String, String> classMap;
	static{
		classMap = new HashMap<String, String>();
		classMap.put("com.zhoukekestar.mybatis.dao.impl.DevicesDaoImpl", "com.zhoukekestar.mybatis.auto.dao.DevicesMapper");
		classMap.put("com.zhoukekestar.mybatis.dao.impl.LedLogDaoImpl", "com.zhoukekestar.mybatis.auto.dao.LedLogMapper");
		classMap.put("com.zhoukekestar.mybatis.dao.impl.UserDaoImpl", "com.zhoukekestar.mybatis.auto.dao.UserMapper");
		classMap.put("com.zhoukekestar.mybatis.dao.impl.UserDaoImpl", "com.zhoukekestar.mybatis.auto.dao.UserMapper");
		classMap.put("com.zhoukekestar.mybatis.dao.impl.UserDaoImpl", "com.zhoukekestar.mybatis.auto.dao.UserMapper");
		classMap.put("com.zhoukekestar.mybatis.dao.impl.UserDaoImpl", "com.zhoukekestar.mybatis.auto.dao.UserMapper");
		classMap.put("com.zhoukekestar.mybatis.dao.impl.UserDaoImpl", "com.zhoukekestar.mybatis.auto.dao.UserMapper");
		classMap.put("com.zhoukekestar.mybatis.dao.impl.UserDaoImpl", "com.zhoukekestar.mybatis.auto.dao.UserMapper");
	}
	private void init() {
		className = classMap.get(this.getClass().getName()).toString();
	}
	
	@Override
	public int countByExample(T2 example) {
		init();
		return session.selectOne(className + ".countByExample", example);
	}
	@Override
	public int deleteByExample(T2 example) {
		init();
		session.delete(className + ".deleteByExample", example);
		session.commit();
		return 0;
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		init();
		session.delete(className + ".deleteByPrimaryKey", id);
		session.commit();
		return 0;
	}
	@Override
	public int insert(T record) {
		init();
		session.insert(className + ".insert", record);
		session.commit();
		return 0;
	}
	@Override
	public int insertSelective(T record) {
		init();
		session.insert(className + ".insertSelective", record);
		session.commit();
		return 0;
	}
	@Override
	public List<T> selectByExampleWithBLOBs(T2 example) {
		init();
		return session.selectList(className + ".selectByExampleWithBLOBs", example);
	}
	@Override
	public List<T> selectByExample(T2 example) {
		init();
		return session.selectList(className + ".selectByExample", example);
	}
	@Override
	public T selectByPrimaryKey(Integer id) {
		init();
		return session.selectOne(className + ".selectByPrimaryKey", id);
	}
	
	@Override
	public int updateByExampleSelective(T record, T2 example) {
		init();
		//session.update(className + ".updateByExampleSelective", record);
		return 0;
	}
	@Override
	public int updateByExampleWithBLOBs(T record, T2 example) {
		return 0;
	}
	@Override
	public int updateByExample(T record, T2 example) {
		return 0;
	}
	@Override
	public int updateByPrimaryKeySelective(T record) {
		init();
		session.update(className + ".updateByPrimaryKeySelective", record);
		session.commit();
		return 0;
	}
	@Override
	public int updateByPrimaryKeyWithBLOBs(T record) {
		init();
		session.update(className + ".updateByPrimaryKeyWithBLOBs", record);
		session.commit();
		return 0;
	}
	@Override
	public int updateByPrimaryKey(T record) {
		init();
		session.update(className + ".updateByPrimaryKey", record);
		session.commit();
		return 0;
	}
	
}
