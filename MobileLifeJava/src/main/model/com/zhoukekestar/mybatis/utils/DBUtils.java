package com.zhoukekestar.mybatis.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static final String RESOURCE = "com/zhoukekestar/mybatis/_config/conf.xml";

	static {
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	public static void addMapper(Class<?> clazz) {
		sqlSessionFactory.getConfiguration().addMapper(clazz);
	}

	public static void showExample()
	{
		String str = "";
		str += "SqlSession session = DBUtils.getSession();\n";
		str += "try {\n";
		
		str += "	UserExample example = new UserExample();\n";
		str += "	example.createCriteria().andIdEqualTo(1);\n";
		
		str += "	UserMapper zUserMapper = session.getMapper(UserMapper.class);\n";
		str += "	User user = zUserMapper.selectByPrimaryKey(1);\n";
		str += "	System.out.println(user.getUseraddress());\n";
		
		str += "	List<User> user2 = zUserMapper.selectByExample(example);\n";
		str += "	System.out.println(user2.size());\n";
		str += "} catch (Exception e) {\n";
		str += "	e.printStackTrace();\n";
		str += "}finally{\n";
		str += "	session.close();\n";
		str += "}\n";
		System.out.println(str);
	}
}
