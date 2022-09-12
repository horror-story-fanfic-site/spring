package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.revature.models.front.FrontEmoji;
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

//		User initialUser = new User("password", "testuser");
		User[] userList = new User[2];
		for(int x=0;x<userList.length;x++) {
			User user = new User();
			user.setId(x+1);
			userList[x]=user;
		}
		
//		Emoji initialEmoji = new Emoji(1, "thumbsup", "its a like");
		Emoji[] emojiList = new Emoji[2];
		for(int x=0;x<emojiList.length;x++) {
			Emoji emoji = new Emoji();
			emoji.setEmojiId(x+1);
			emojiList[x]=emoji;
		}
		
		Post[] postList=new Post[2];
		//Sorry that it is a mess.
		//Set id, like a post list using numbers above, and
		for(int x=0;x<postList.length;x++) {
			Post post = new Post();
			post.setId(x+1);
			List<LikeAPost> likeAPostList = new ArrayList<LikeAPost>();
			post.setEmojiList(likeAPostList);
			postList[x]=post;
			
			when(postRepository.getReferenceById(x+1)).thenReturn(postList[x]);
		}
		when(postRepository.getReferenceById(3)).thenReturn(null);
		
		LikeAPost[] likeList = new LikeAPost[3];
		//array index is 1 lower than id.
		int[] postLike = {0, 1, 0};
		int[] userLike = {1, 1, 0};
		int[] emojiLike = {0, 1, 0};
		for(int x=0;x<likeList.length;x++) {
			LikeAPost likePost =  new LikeAPost();
			likePost.setLikeId(x+1);
			likePost.setOwner(userList[userLike[x]]);
			likePost.setEmoji(emojiList[emojiLike[x]]);
			postList[postLike[x]].getEmojiList().add(likePost);
		}
		
		
		//Setting up tests below here.
		//array index is 1 lower than id.
		//NOTE the data in post is being altered each test.
		
		//test one add
		LikeAPost like1 = new LikeAPost(0, userList[0], emojiList[0]);
		int postId1=2;
		List<LikeAPost> result1 = new ArrayList<LikeAPost>();
		LikeAPost resultLike11 = new LikeAPost(2, userList[1], emojiList[1]);
		LikeAPost resultLike12 = new LikeAPost(4, userList[1], emojiList[1]);
		when(likeAPostRepository.save(like1)).thenReturn(resultLike12);
		result1.add(resultLike11);
		result1.add(resultLike12);
		
		service.postEmoji(postId1, like1);
		
		verify(postRepository, times(1)).getReferenceById(2);
		verify(likeAPostRepository, times(1)).save(like1);
		verify(postRepository, times(1)).save(postList[1]);
		
		assertEquals(result1, postList[1].getEmojiList());
		
		
		//test two remove
		LikeAPost like2 = new LikeAPost(0, userList[0], emojiList[0]);
		int postId2=1;
		List<LikeAPost> result2 = new ArrayList<LikeAPost>();
		LikeAPost resultLike21 = new LikeAPost(1, userList[1], emojiList[0]);
		result2.add(resultLike21);
		
		service.postEmoji(postId2, like2);
		
		verify(postRepository, times(1)).getReferenceById(1);
		verify(likeAPostRepository, times(1)).deleteById(3);
		verify(postRepository, times(1)).save(postList[0]);
		
		assertEquals(result2, postList[0].getEmojiList());
		
		
		//Test 3 exception
		LikeAPost like3 = new LikeAPost(0, userList[0], emojiList[0]);
		int postId3=3;

		assertThrows(IllegalArgumentException.class, ()-> service.postEmoji(postId3, like3));
		verify(postRepository, times(1)).getReferenceById(3);
		
		
//		when(likeAPostRepository.save(initialLikeAPost)).thenReturn(initialLikeAPost);

		// Act
//			service.postEmoji(1, initialLikeAPost);
		

		// Assert
//		verify(postRepository, times(1)).getReferenceById(1);
//		verify(likeAPostRepository, times(1)).save(initialLikeAPost);
//		verify(postRepository, times(1)).save(initialPost);
		
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

	@Test
	void getPostEmojis() {
		Post[] posts = new Post[3];
		for(int x=0;x<posts.length;x++) {
			Post post = new Post();
			post.setId(x+1);
			post.setEmojiList(new ArrayList<LikeAPost>());
			posts[x]=post;
			when(postRepository.getReferenceById(x + 1)).thenReturn(post);
		}
		when(postRepository.getReferenceById(posts.length+1)).thenReturn(null);
		User[] users = new User[3];
		for (int x=0;x<users.length;x++) {
			User user = new User();
			user.setId(x+1);
			users[x]=user;
		}
		Emoji[] emojies = new Emoji[3];
		for(int x=0;x<emojies.length;x++) {
			Emoji emoji = new Emoji();
			emoji.setEmojiId(x+1);
			emojies[x]=emoji;
		}
		
		posts[1].getEmojiList().add(
			new LikeAPost(1, users[0], emojies[0])
		);
		posts[1].getEmojiList().add(
			new LikeAPost(3, users[1], emojies[0])
		);
		posts[2].getEmojiList().add(
			new LikeAPost(2, users[0], emojies[2])
		);
		posts[2].getEmojiList().add(
			new LikeAPost(5, users[1], emojies[1])
		);
		posts[2].getEmojiList().add(
			new LikeAPost(4, users[2], emojies[2])
		);
		
		//Test exception
		
		assertThrows(IllegalArgumentException.class, ()-> service.getPostEmojis(4, 1));
		assertThrows(IllegalArgumentException.class, ()-> service.getPostEmojis(4, 2));
		
		verify(postRepository, times(2)).getReferenceById(4);
		
		//test empty post.
		List<FrontEmoji> front1 = new ArrayList<FrontEmoji>();
		assertEquals(front1, service.getPostEmojis(1, 1));
		assertEquals(front1, service.getPostEmojis(1, 2));
		assertEquals(front1, service.getPostEmojis(1, 3));
		
		verify(postRepository, times(3)).getReferenceById(1);
		
		//test post 2
		List<FrontEmoji> front2 = new ArrayList<FrontEmoji>();
		front2.add(new FrontEmoji(emojies[0], 2, true));
		
		assertEquals(front2, service.getPostEmojis(2, 1));
		assertEquals(front2, service.getPostEmojis(2, 2));
		

		List<FrontEmoji> front3 = new ArrayList<FrontEmoji>();
		front3.add(new FrontEmoji(emojies[0], 2, false));
		assertEquals(front3, service.getPostEmojis(2, 3));
		
		verify(postRepository, times(3)).getReferenceById(2);
		
		//test post 3
		List<FrontEmoji> front4 = new ArrayList<FrontEmoji>();
		front4.add(new FrontEmoji(emojies[2], 2, true));
		front4.add(new FrontEmoji(emojies[1], 1, false));
		
		assertEquals(front4, service.getPostEmojis(3, 1));
		
		List<FrontEmoji> front5 = new ArrayList<FrontEmoji>();
		front5.add(new FrontEmoji(emojies[2], 2, false));
		front5.add(new FrontEmoji(emojies[1], 1, true));
		
		assertEquals(front5, service.getPostEmojis(3, 2));
		
		List<FrontEmoji> front6 = new ArrayList<FrontEmoji>();
		front6.add(new FrontEmoji(emojies[2], 2, true));
		front6.add(new FrontEmoji(emojies[1], 1, false));
		
		assertEquals(front6, service.getPostEmojis(3, 3));
		
		verify(postRepository, times(3)).getReferenceById(3);
	}
}
