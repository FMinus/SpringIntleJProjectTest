package com.mainPackage.metier;

import com.mainPackage.entity.Authority;
import com.mainPackage.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserMetier
{
	public User addUser(User user);
	public User findOneByUsername(String username);
	public User grantAuthority2User(Authority auth, User user);

	public List<User> listAllUsers();
	public List<User> findUsers(String mc);

	public Page<User> pageAllUsers(Pageable pgbl);
	public Page<User> findUsers(Pageable pgbl,String mc);



}
