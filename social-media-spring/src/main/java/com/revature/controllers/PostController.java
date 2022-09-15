package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
//@CrossOrigin(origins = "http://44.201.120.76:4200", allowCredentials = "true")
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
    @GetMapping("/followposts")
    public ResponseEntity<List<Post>> getAllFollowerPosts(HttpSession session) {
    	System.out.println("reached the follow post\t\n\n\n\n");
    	User currentUser = (User) session.getAttribute("user");
    	List<User> followingList = currentUser.getPeopleFollowed();
    	List<String> followingListName = new ArrayList<>();
    	for(User user : followingList) {
    		followingListName.add(user.getUsername());
    	}
    	Set<String>  userFilterSet = followingListName.stream().collect(Collectors.toSet()); 
    	List<Post> allPosts = postService.getAll();
    	List<Post> filteredPosts = new ArrayList<>();
    	
    	filteredPosts = allPosts.stream().filter(post -> userFilterSet.contains(post.getAuthor().getUsername()))
    						.collect(Collectors.toList());
    	
    	return ResponseEntity.ok(filteredPosts);
    }
    
    @Authorized
    @PutMapping
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
    	return ResponseEntity.ok(this.postService.upsert(post));
    }
    
    /***
     * This is the end point to add an emoji to a post.
     * 
     * @param session
     * @param req	emojiId 	PostId
     * @return
     */
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
    
    /***
     * The end point for getting all the emojis assigned to a post
     * 
     * @param session
     * @param req	postId
     * @return	a FrontEmoji list
     */
    @Authorized
    @PostMapping(value="/getEmojis")
    public ResponseEntity<List<FrontEmoji>> getPostEmojis(HttpSession session, HttpServletRequest req) {

    	int postId = Integer.parseInt(req.getParameter("postId"));
    	int userId = ((User)session.getAttribute("user")).getId();
    	//TODO try catch for different status to above.
    	
    	List<FrontEmoji> results=postService.getPostEmojis(postId, userId);
    	
    	return ResponseEntity.ok(results);
    	
    }
}
