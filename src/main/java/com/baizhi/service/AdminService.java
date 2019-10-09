package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
	Admin queryAdmin(String username,String password);
}
