package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {

	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="text", nullable=true, length=70000)
	private String text;
	
>>>>>>> 46c8698274d2de5ae2531cbcece467f2fc416484

	@Column(name = "text", nullable = true)
	private String text;

	@Column(name = "image_url", nullable = true)
	private String imageUrl;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> comments;

	@ManyToOne
	private User author;

	@OneToMany
	private List<LikeAPost> emojiList;

	public Post(int id, String text) {

		super();
		this.id = id;
		this.text = text;
	}
}
