package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Emoji;
import com.revature.models.LikeAPost;
import com.revature.models.Post;
import com.revature.models.front.FrontEmoji;
import com.revature.repositories.EmojiRepository;
import com.revature.repositories.LikeAPostRepository;
import com.revature.repositories.PostRepository;

@Service
public class PostService { // implements PostServiceInterface {

	private final PostRepository postRepository;
	private final LikeAPostRepository likeAPostRepository;
	private final EmojiRepository emojiRepository;
	
	public PostService(PostRepository postRepository, LikeAPostRepository likeAPostRepository, EmojiRepository emojiRepository) {
		this.postRepository = postRepository;
		this.likeAPostRepository = likeAPostRepository;
		this.emojiRepository = emojiRepository;
	}

	public List<Post> getAll() {
		return this.postRepository.findAll();
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}
	
	/***
	 * This is for adding that a user gave a post an emoji.
	 * Doing this again will delete the emoji record.
	 * @param postId
	 * @param like
	 */
	public synchronized void postEmoji(int postId, LikeAPost like) {
		Post post = postRepository.getReferenceById(postId);
		
		if (post==null) {
			throw new IllegalArgumentException();
		}
		List<LikeAPost> postLikes = post.getEmojiList();
		int likeId=0;
		int x;
		for(x=0;x<postLikes.size();x++) {
			if (postLikes.get(x).isEqual(like)) {
				likeId=postLikes.get(x).getLikeId();
				break;
			}
		}
		if (likeId==0) {
			like=likeAPostRepository.save(like);
			post.getEmojiList().add(like);
			postRepository.save(post);
		}else {
			post.getEmojiList().remove(x);
			postRepository.save(post);
			likeAPostRepository.deleteById(likeId);
		}
	}
	
	public Emoji getEmoji(int id) {
		return emojiRepository.getReferenceById(id);
	}
	
	public Post getPost(int id) {
		return postRepository.getReferenceById(id);
	}
	
	public synchronized List<FrontEmoji> getPostEmojis(int postId, int userId){
		Post post = postRepository.getReferenceById(postId);
		
		if (post==null) {
			throw new IllegalArgumentException();
		}
		List<LikeAPost> postLikes = post.getEmojiList();
		List<FrontEmoji> results = new ArrayList<FrontEmoji>();
		
		for(int x=0;x<postLikes.size();x++) {
			
			int frontIndex;//To test if it existed before.
			for(frontIndex=0;frontIndex<results.size();frontIndex++) {
				if (results.get(frontIndex).getEmoji()==postLikes.get(x).getEmoji()) {
					break;
				}
			}
			
			if (frontIndex==results.size()) {
				results.add(new FrontEmoji(postLikes.get(x).getEmoji(), 0, false));
			}
			
			int count=results.get(frontIndex).getCount();
			count++;
			results.get(frontIndex).setCount(count);
			
			if (postLikes.get(x).getOwner().getId()==userId) {
				results.get(frontIndex).setYou(true);
			}
		}
		return results;
	}
}
