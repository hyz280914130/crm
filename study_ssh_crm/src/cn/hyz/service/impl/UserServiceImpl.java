package cn.hyz.service.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.hyz.dao.UserDao;
import cn.hyz.domain.User;
import cn.hyz.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao;
	
	@Override
	public User getUser(User u) {
		//查询用户
		User user = dao.getUser(u.getUser_code(),u.getUser_password());
		//判断用户是否存在
		if(user==null) {
			throw new RuntimeException("用户名或密码错误");
		}
//		if(!user.getUser_code().equals(u.getUser_code())) {
//			throw new RuntimeException("账户名错误");
//		}
//		if(!user.getUser_password().equals(u.getUser_password())) {
//			throw new RuntimeException("密码错误");
//		}
		return user;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

}
