package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "like_a_post")
public class LikeAPost {
	
	@Id
    @Column(name="like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
	
	@ManyToOne
	private User owner;
	
	@ManyToOne
	private Emoji emoji;
	
	public boolean isEqual(LikeAPost comparison) {
		
		if (comparison.getOwner().getId()!=owner.getId()) {
			return false;
		}else if(comparison.getEmoji().getEmojiId()!=emoji.getEmojiId()) {
			return false;
		}
		
		return true;
	}
}
