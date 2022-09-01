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
@Table(name = "emojis")
public class Emoji {
	
	@Id
    @Column(name="emoji_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emojiId;
	
	@Column(name="emoji_type", nullable=true)
	private String emojiType;
	
	@ManyToOne
	private User emojiOwner;

}
