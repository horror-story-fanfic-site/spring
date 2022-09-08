package com.revature.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.controllers.PostController;
import com.revature.models.Post;
import com.revature.services.PostService;
import com.revature.services.UserService;

public class PostControllerTests {

    PostController myControl;

    @Mock
    PostService myPostServ;

    @Mock
    UserService myUserServ;

    @BeforeEach
    void setUp() throws Exception {
        myControl = new PostController(myPostServ, myUserServ);
    }

    @Test
    void getAllPostsTest() throws Exception {
        Post myPost = new Post(10000, "The classic");
        List<Post> myPosts = Arrays.asList(myPost);

        Mockito.when(myPostServ.getAll()).thenReturn(myPosts);
    }

}
