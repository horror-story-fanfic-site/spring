package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Emoji;
import com.revature.models.LikeAPost;
import com.revature.models.Post;
import com.revature.repositories.EmojiRepository;
import com.revature.repositories.LikeAPostRepository;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

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
	
	public void postEmoji(int postId, LikeAPost like) {
		like=likeAPostRepository.save(like);
		Post post = postRepository.getReferenceById(postId);
		if (post!=null) {
			post.getEmojiList().add(like);
			postRepository.save(post);
		}
	}
	
	public Emoji getEmoji(int id) {
		return emojiRepository.getReferenceById(id);
	}
	
	public Post getPost(int id) {
		return postRepository.getReferenceById(id);
	}
}
