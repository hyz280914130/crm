package cn.hyz.inteceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.hyz.domain.User;

public class AutoLogin extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if(user==null) {
			System.out.println("session中没有用户");
			return "toLogin";
		}else {
			System.out.println("session有用户的");
			return invocation.invoke();
		}
	}

}
