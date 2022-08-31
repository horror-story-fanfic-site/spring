package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

   

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
//    @ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
//    private List<User> user;
//    
    
    @Column(name="email", nullable=false)
    private String email;
    
    @Column(name="password", nullable=false)
    private String password;
    
    @Column(name="first_name", nullable=false)
    private String firstName;
    
    @Column(name="last_name", nullable=false)
    private String lastName;
    
    @Column(name="username", nullable=false)
    private String username;
    
    @Column(name="profile_pic", nullable=true)
    private String profilePic;
    
    @Column(name="description", nullable=true)
    private String description;
    
    @Column(name="birth_day", nullable=true)
    private String birthDay;
    
    @Column(name="birth_month", nullable=true)
    private String birthMonth;
    
    @Column(name="birth_year", nullable=true)
    private String birthYear;
    
    @OneToMany
    @JoinColumn(name = "posts_fk")
    private List<Post> posts;
    
    @OneToMany
    private List<User> followers;

	public User(int id, String email, String password, String firstName, String lastName, String username) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}
    
    
    
    
}