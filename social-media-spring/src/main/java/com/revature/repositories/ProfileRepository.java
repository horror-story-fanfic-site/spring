package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
