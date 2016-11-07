package com.mainPackage.security.controller;

import javax.servlet.http.HttpServletRequest;

import com.mainPackage.entity.User;
import com.mainPackage.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mainPackage.security.jwt.JwtTokenUtil;
import com.mainPackage.security.jwt.JwtUser;

import java.util.List;


@RestController
public class UserRestController
{
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private UserMetier userMetier;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) 
    {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "allUsers", method = RequestMethod.GET)
    public List<User> getAll()
    {
        return userMetier.listAllUsers();
    }


    @RequestMapping(value = "myTest", method = RequestMethod.GET)
    public String myTest()
    {
        return "myTest";
    }
}
