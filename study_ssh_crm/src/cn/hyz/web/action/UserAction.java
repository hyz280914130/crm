package cn.hyz.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hyz.domain.User;
import cn.hyz.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	User user = new User();
	private UserService userService;
	
	public String login() throws Exception {
		
		//查询用户
		User u = userService.getUser(user);
		//如果用户存在将其放入session中
		ActionContext.getContext().getSession().put("user", u);
		//返回结果，跳转到指定页面
		return "toHome";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
	
		return user;
	}
	
}
