package com.niit.dao.impl;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Role;
import com.niit.dao.UserDao;
import com.niit.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
/*
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
*/
	@Transactional
	public void saveUser(User userinfo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userinfo);
	}
	/*@Transactional
	public boolean checklogin(String userName,String password) {
		boolean userFound = false;
		Query query=sessionFactory.getCurrentSession().createQuery("from User where userName=? and password=?");
		query.setParameter(0,userName);
		query.setParameter(1,password);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		return userFound;  
	}*/
	@Transactional
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Transactional
	public void editUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Transactional
	public void deleteUser(int userId) {
		sessionFactory.getCurrentSession().delete(findUser(userId));
	}

	@Transactional
	public User findUser(int userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Transactional
	public User findUserByName(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));		
		return (User) criteria.uniqueResult();
	}
	@Transactional
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	
	
}
