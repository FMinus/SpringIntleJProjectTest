 package com.mainPackage.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mainPackage.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


 public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUsername(String username);

	@Query("select u from User u")
	Page<User> findAllUsers(Pageable pageable);

	@Query("select u from User u where (u.username like :u or u.firstname like :u or u.lastname like :u) ")
	Page<User> findUsersLikePage(@Param("u") String mc, Pageable pageable);

	@Query("select u from User u where (u.username like :u or u.firstname like :u or u.lastname like :u) ")
	List<User> findUsersLikeList(@Param("u") String mc);
}
