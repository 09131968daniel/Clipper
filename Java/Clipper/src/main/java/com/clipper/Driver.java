package com.clipper;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clipper.dao.PostDao;
import com.clipper.dao.UserDao;
import com.clipper.model.Like;
import com.clipper.model.Post;
import com.clipper.model.PostImage;
import com.clipper.model.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		
		
		UserDao dao = ac.getBean(UserDao.class);
		PostDao pdao = ac.getBean(PostDao.class);
		
		
		
		dao.save(new User(0, "nathan1", "AAA", "Nathan", "Ricks", "ricks@gmail.com", "lol bio", "pfp link", null, null));
		//dao.save(new User(0, "user2", "password", "User", "Name", "user@nothing.net", "biography", "profile pic", null, null));
		
		pdao.save(new Post(0, "Hello World", dao.findById(2), null, null));
		
		//dao.delete(1);
		
		System.out.println(dao.findAll());
		
		System.out.println("Success!");
		
		
	}

	
}