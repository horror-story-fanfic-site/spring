/**
 * 
 */
package com.revature.services;

import java.util.List;

import com.revature.models.Post;

/**
 * @author wahoo
 *
 */
public interface PostServiceInterface {
	
	public List<Post> getAll() ;


	public Post upsert(Post post) ;

}
