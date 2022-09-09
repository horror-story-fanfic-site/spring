package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.Emoji;
import com.revature.models.LikeAPost;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.models.front.FrontEmoji;
import com.revature.services.PostService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PostController {

	private final PostService postService;
	private final UserService userService;
	

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }
    
    @Authorized
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
    	return ResponseEntity.ok(this.postService.getAll());
    }
    
    @Authorized
    @PutMapping
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
    	return ResponseEntity.ok(this.postService.upsert(post));
    }
    
    @Authorized
    @PostMapping("/likePost")
    public ResponseEntity<String> likePost(HttpSession session, HttpServletRequest req){
    	
    	User user = (User)session.getAttribute("user");
    	user = userService.getuserById(user.getId());
    	Emoji emoji = postService.getEmoji(Integer.parseInt(req.getParameter("emojiId")));
    	//TODO try catch for different status to above.
    	
    	LikeAPost likeAPost = new LikeAPost(0, user, emoji);
    	try {
        	postService.postEmoji(Integer.parseInt(req.getParameter("postId")), likeAPost);
        	ResponseEntity.status(200);
    	}
    	catch(IllegalArgumentException e) {
    		
    		ResponseEntity.status(400);
    		//Not sure how to get this to work.
//    		return ResponseEntity.ok("");
    	}
    	
    	return ResponseEntity.ok("");
    }
    
    @Authorized
	@GetMapping(value="/testSession")
	public void testSession(HttpSession session){
		
		User currentUser = (User) session.getAttribute("user");
		
		System.out.println(currentUser);
//		return ResponseEntity.ok(currentUser.getFollowers());
		
		
	}
    
    @Authorized
    @PostMapping(value="/getEmojis")
    public ResponseEntity<List<FrontEmoji>> getPostEmojis(HttpServletRequest req) {

    	int postId = Integer.parseInt(req.getParameter("emojiId"));
    	int userId = Integer.parseInt(req.getParameter("userId"));
    	//TODO try catch for different status to above.
    	
    	List<FrontEmoji> results=postService.getPostEmojis(postId, postId);
    	
    	return null;
    	
    }
}
