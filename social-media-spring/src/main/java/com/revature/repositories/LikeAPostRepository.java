package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.LikeAPost;

public interface LikeAPostRepository extends JpaRepository<LikeAPost, Integer>{

}
