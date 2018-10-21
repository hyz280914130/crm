package cn.hyz.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.hyz.dao.UserDao;
import cn.hyz.domain.User;

//HibernateDaoSupport也是需要sessionFactory的，所以需要为dao注入sessionFactory
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUser(String user_code, String user_password) {
		User user = getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String sql = "from User where user_code=? and user_password=?";
				Query query = session.createQuery(sql);
				query.setParameter(0, user_code);
				query.setParameter(1, user_password);
				User user = (User) query.uniqueResult();
				return user;
			}
		});
		return user;
	}


}
