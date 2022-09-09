package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Emoji;

public interface EmojiRepository extends JpaRepository<Emoji, Integer>{

}
