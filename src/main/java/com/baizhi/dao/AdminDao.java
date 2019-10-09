package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {
	Admin selectAdmin(String username,String password);
}
