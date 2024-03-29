package com.clipper.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clipper.model.User;

@Repository
public class UserDao implements Dao<User, Integer> {

	private SessionFactory factory;
	
	@Autowired
	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public UserDao() { }
	
	@Override
	public List<User> findAll() {
		Session sess = factory.openSession();
		List<User> list =sess.createNativeQuery("select * from users", User.class).list();
		sess.close();
		return list;
	}

	@Override
	public User findById(Integer i) {
		Session sess = factory.openSession();
		User result = sess.createQuery("from User where id = " + i, User.class).list().get(0);
		sess.close();
		return result;
	}

	@Override
	public User update(User t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		sess.close();
		return t;
	}

	@Override
	public User save(User t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		sess.close();
		return t;
	}

	@Override
	public User delete(Integer i) {
		User u = findById(i);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(u);
		tx.commit();
		sess.close();
		return u;
	}
	
	public User findUserByUsername(String username) {
		Session sess = factory.openSession();
		User result = sess.createQuery("from User where username = '" + username +"'", User.class).list().get(0);
		sess.close();
		return result;
	}
	
	public User findUserByEmail(String email) {
		Session sess = factory.openSession();
		User result = sess.createQuery("from User where email = '" + email +"'", User.class).list().get(0);
		sess.close();
		return result;
	}
	
	public void deleteAll() {
		Session sess = factory.openSession();
		sess.createQuery("delete from User");
		sess.close();
	}
	
}