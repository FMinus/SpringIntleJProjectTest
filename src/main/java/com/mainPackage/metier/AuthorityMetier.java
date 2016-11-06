package com.mainPackage.metier;

import com.mainPackage.entity.Authority;
import com.mainPackage.entity.User;

public interface AuthorityMetier
{
	public Authority findAuthorityByName(String authName);
	public Authority saveAuthority(Authority auth);
	public void updateAuthority(Authority auth);
	

}
