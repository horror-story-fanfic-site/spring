package com.revature.models.front;

import com.revature.models.Emoji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author phantom
 * This is for returning the values to user in an efficient manner.
 * Count is how many times the emoji is in use on the post.
 * you is if the current user is among the count.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontEmoji {
	private Emoji emoji;
	private int count;
	private boolean you;
}
