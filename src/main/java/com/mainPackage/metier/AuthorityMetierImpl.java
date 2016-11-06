package com.mainPackage.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainPackage.dao.AuthorityRepository;
import com.mainPackage.entity.Authority;
import com.mainPackage.entity.User;



@Service
public class AuthorityMetierImpl implements AuthorityMetier
{
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private UserMetier userMetier;

	@Override
	public Authority saveAuthority(Authority auth) {
		return authorityRepository.save(auth);
	}

	@Override
	public Authority findAuthorityByName(String authName) {
		return authorityRepository.findByName(authName);
	}

	@Override
	public void updateAuthority(Authority auth) {
		
		//authorityRepository.
		
	}

	

}
