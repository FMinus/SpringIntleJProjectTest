package com.mainPackage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainPackage.entity.Authority;




public interface AuthorityRepository extends JpaRepository<Authority, Long>
{
	public Authority findByName(String authName);

}
