package com.revature.models.front;

import com.revature.models.Emoji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontEmoji {
	private Emoji emoji;
	private int count;
	private boolean you;
}
