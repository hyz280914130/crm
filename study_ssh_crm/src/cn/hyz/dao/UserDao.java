package cn.hyz.dao;

import cn.hyz.domain.User;

public interface UserDao {
	
	User getUser(String user_code,String user_password);
}
