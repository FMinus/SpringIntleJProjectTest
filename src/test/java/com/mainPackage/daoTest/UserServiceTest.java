package com.mainPackage.daoTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mainPackage.entity.Authority;
import com.mainPackage.entity.User;
import com.mainPackage.metier.AuthorityMetier;
import com.mainPackage.metier.UserMetier;
import com.mainPackage.utilities.Passwords;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest
{
	@Autowired
	private UserMetier userMetier;
	
	@Autowired
	private AuthorityMetier authorityMetier;
	
	@Test
	public void addDummyAuthorities()
	{
		Authority admin = authorityMetier.findAuthorityByName("ROLE_ADMIN");
		Authority user =authorityMetier.findAuthorityByName("ROLE_USER");
		
		if(admin == null)
		{
			admin = new Authority("ROLE_ADMIN");
			authorityMetier.saveAuthority(admin);
		}
		
		if(user == null)
		{
			user = new Authority("ROLE_USER");
			authorityMetier.saveAuthority(user);
		}
		
		
		
		admin = authorityMetier.findAuthorityByName("ROLE_ADMIN");
		user = authorityMetier.findAuthorityByName("ROLE_USER");
		
		//assert(admin.getName() == "ROLE_ADMIN" && user.getName() == "ROLE_USER");
		//assert(admin.getName() != null && user.getName() != null);
	}
	
	@Test
	//@Transactional
	public void addDummyAccounts()
	{
		Authority adminAuth = authorityMetier.findAuthorityByName("ROLE_ADMIN");
		Authority userAuth = authorityMetier.findAuthorityByName("ROLE_USER");
		
		if(adminAuth == null || userAuth == null);
			addDummyAuthorities();
		
		
		/* users with admin Auth */
		List<Authority> listAdminAuths = new ArrayList<>();
		listAdminAuths.add(adminAuth);
		listAdminAuths.add(userAuth);
		
		
		/*users with user Auth*/
		List<Authority> listUserAuth = new ArrayList<>();
		listUserAuth.add(userAuth);
		
		
		
		User admin = userMetier.findOneByUsername("admin");
		User user = userMetier.findOneByUsername("user");
		User disabled = userMetier.findOneByUsername("disabled");
		
		/* adding admin acount */
		if(admin == null)
		{
			admin = new User("admin", Passwords.hashPassword("admin"), "firstNameAdmin", "lastNameAdmin", "admin@mail.org", true, new Date(),"nophoto.png", listAdminAuths);
			admin = userMetier.addUser(admin);
		}
		
		/*  Adding regular user  */
		if(user == null)
		{
			user = new User("user", Passwords.hashPassword("user"), "firstNameUser", "lastNameUser", "user@mail.org", true, new Date(),"nophoto.png", listUserAuth);
			user = userMetier.addUser(user);
		}
		
		/* adding disabled account */
		if(disabled == null)
		{
			disabled = new User("disabled", Passwords.hashPassword("disabled"), "firstNamedisabled", "lastNamedisabled", "disabled@mail.org", false, new Date(),"nophoto.png", listAdminAuths);
			disabled = userMetier.addUser(disabled);
		}	

	}
	
	

}
