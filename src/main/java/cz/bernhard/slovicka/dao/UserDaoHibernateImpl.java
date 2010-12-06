package cz.bernhard.slovicka.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.bernhard.slovicka.domains.User;

public class UserDaoHibernateImpl extends HibernateDaoSupport implements
		IUserDao {

	public User save(User user) {
		getHibernateTemplate().save(user);
		return user;
	}

	public List<User> findAll() {
		return getHibernateTemplate().find("from users");
	}

}
