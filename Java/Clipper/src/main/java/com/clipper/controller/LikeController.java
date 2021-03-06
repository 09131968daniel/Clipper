package com.clipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clipper.dto.LikeDTO;
import com.clipper.model.Like;
import com.clipper.model.Post;
import com.clipper.model.User;
import com.clipper.service.LikeService;
import com.clipper.service.PostService;
import com.clipper.service.UserService;
import com.clipper.util.Utilities;

@Controller
@CrossOrigin
public class LikeController {
	
	private LikeService ls;
	
	@Autowired
	private PostService ps;
	@Autowired
	private UserService us;
	

	public LikeService getPps() {
		return ls;
	}
	
	@Autowired
	public void setPps(LikeService ls) {
		this.ls = ls;
	}
	
	/**
	 * Add a like to a post.  If it's already liked, remove it.  Note, use criteria api for complicated queries, not loops.
	 * @param dto The like 
	 * @return Either the removed like or the added like
	 */
	@PostMapping("/addLike.json")
	public @ResponseBody Like addLike(@RequestBody LikeDTO dto) {
		Like li = null;
		Post p = null;
		User u = null;
		try {
			System.out.println(dto.getPost_id() + " " + dto.getUser_id());
			p = ps.findById(dto.getPost_id());
			u = us.getUserById(dto.getUser_id());
			li = ls.addLike(new Like(0, p, u));
			Utilities.log(u.getUsername() + " liked the post with an ID of " + p.getId());
			return li;
		}
		catch(Exception e) {
			System.out.println("No more than one like per person.");
		}
		//remove the like
		List<Object[]> result = ls.findByUserAndPost(p.getId(), u.getId());
		String likeId = null;
		for(Object[] obj : result){likeId = String.valueOf(obj[0]);}
		Utilities.log(u.getUsername() + " unliked the post with an ID of " + p.getId());
		return ls.removeLike(Integer.parseInt(likeId));
	}
	
}
