package com.mainPackage.metier;

import com.mainPackage.entity.Authority;
import com.mainPackage.entity.User;

public interface UserMetier
{
	public User addUser(User user);
	public User findByUsername(String username);
	public User grantAuthority2User(Authority auth, User user); 
}
