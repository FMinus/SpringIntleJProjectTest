package com.mainPackage.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mainPackage.dao.UserRepository;
import com.mainPackage.entity.Authority;
import com.mainPackage.entity.User;

@Service
public class UserMetierImpl implements UserMetier
{
	@Autowired
	private UserRepository userRespository;

	@Override
	public User addUser(User user) 
	{
		return userRespository.save(user);
		
	}

	@Override
	public User findOneByUsername(String username) {
		return userRespository.findByUsername(username);
	}
	
	@Override
	public User grantAuthority2User(Authority auth, User user) 
	{
		//TODO use streams
		//List<User> listUsers;
		List<Authority> listAuth;
		
		if(user.getAuthorities() == null)
		{
			listAuth = new ArrayList<>();
		}
		else
		{
			listAuth = user.getAuthorities();
		}
		
		if(user.getAuthorities().contains(auth))
			throw new RuntimeException("User already has authority : "+auth.getName());
		
		
		listAuth.add(auth);
		user.setAuthorities(listAuth);		
		
		return userRespository.save(user);
	}

	@Override
	public List<User> listAllUsers()
	{
		return userRespository.findAll();
	}

	@Override
	public List<User> findUsers(String mc)
	{
		return userRespository.findUsersLikeList(mc);
	}

	@Override
	public Page<User> pageAllUsers(Pageable pgbl)
	{
		return userRespository.findAllUsers(pgbl);
	}

	@Override
	public Page<User> findUsers(Pageable pgbl, String mc)
	{
		return userRespository.findUsersLikePage(mc,pgbl);
	}


}
