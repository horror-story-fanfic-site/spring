package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
@EqualsAndHashCode
public class Profile {
	
	@Id
	@Column(name="profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "profile_pic")
	private String profilePic;
	
	@Column(name = "birth_day")
	private int birthDay;
	
	@Column(name = "birth_month")
	private int birthMonth;
	
	@Column(name = "birth_year")
	private int birthYear;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "post_fk")
	private Post post;


}
