 package com.mainPackage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainPackage.entity.User;




public interface UserRepository extends JpaRepository<User, Long>
{
	public User findByUsername(String username);
	

}
