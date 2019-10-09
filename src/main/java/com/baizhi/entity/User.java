package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private String id;
	private String email;
	private String salt;
	private String nickName;
	private String status;
	private String code;
	private Date createDate;
}
