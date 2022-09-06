package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "profile_pic", nullable = true)
    private String profilePic;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "birth_day", nullable = true)
    private String birthDay;

    @Column(name = "birth_month", nullable = true)
    private String birthMonth;

    @Column(name = "birth_year", nullable = true)
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

	/**
	 * @param password
	 * @param username
	 */
	public User(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}

//	/**
//	 * @param email
//	 * @param password
//	 */
//	public User(String email, String password) {
//		super();
//		this.email = email;
//		this.password = password;
//	}
    
    
}