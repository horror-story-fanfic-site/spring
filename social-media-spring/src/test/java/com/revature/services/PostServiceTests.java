package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Emoji;
import com.revature.models.LikeAPost;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.EmojiRepository;
import com.revature.repositories.LikeAPostRepository;
import com.revature.repositories.PostRepository;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PostServiceTests {

	@Mock
	private PostRepository postRepository;

	@Mock
	private LikeAPostRepository likeAPostRepository;

	@Mock
	private EmojiRepository emojiRepository;

	private PostService service;

	@BeforeEach
	void setUp() {
		service = new PostService(postRepository, likeAPostRepository, emojiRepository);
	}

	@Test
	void postEmojiTest() {

		User initialUser = new User("password", "testuser");
		Emoji initialEmoji = new Emoji(1, "thumbsup", "its a like");
		LikeAPost initialLikeAPost = new LikeAPost(1, initialUser, initialEmoji);
		Post sparePost = new Post(2, "comments");
		List<LikeAPost> emojiList = new ArrayList<>();
		emojiList.add(initialLikeAPost);
		List<Post> postList = new ArrayList<>();
		postList.add(sparePost);
		Post initialPost = new Post(1, "test", "image", postList, initialUser, emojiList);

		when(postRepository.getReferenceById(1)).thenReturn(initialPost);
		when(likeAPostRepository.save(initialLikeAPost)).thenReturn(initialLikeAPost);

		// Act
			service.postEmoji(1, initialLikeAPost);

		// Assert
		verify(postRepository, times(1)).getReferenceById(1);
		verify(likeAPostRepository, times(1)).save(initialLikeAPost);
		verify(postRepository, times(1)).save(initialPost);
	}

	@Test
	void getEmojiTest() {
		Emoji[] emoji = { new Emoji(1, "like", "like a post"), new Emoji(2, "hand wave", "hand is waved."),
				new Emoji(3, "bye", "hand is waved for good bye.") };
		for (int x = 0; x < emoji.length; x++) {
			when(emojiRepository.getReferenceById(x + 1)).thenReturn(emoji[x]);
		}
		assertEquals(emoji[0], service.getEmoji(1));
		assertEquals(emoji[1], service.getEmoji(2));
		assertEquals(emoji[2], service.getEmoji(3));
	}

	@Test
	void getPostTest() {
		Post[] posts = new Post[3];
		for (int x = 0; x < posts.length; x++) {
			Post post = new Post();
			post.setId(x + 1);
			posts[x] = post;

			when(postRepository.getReferenceById(x + 1)).thenReturn(post);
		}
		assertEquals(posts[0], service.getPost(1));
		assertEquals(posts[1], service.getPost(2));
		assertEquals(posts[2], service.getPost(3));
	}

}
