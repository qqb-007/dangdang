package com.baizhi.service;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;

import com.baizhi.util.MybatisUtils;


public class AdminServiceImpl implements AdminService {

	@Override
	public Admin queryAdmin(String username, String password) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		AdminDao ad =sqlSession.getMapper(AdminDao.class);
		Admin admin =ad.selectAdmin(username,password );
		MybatisUtils.close();
		return admin;
	}

}
