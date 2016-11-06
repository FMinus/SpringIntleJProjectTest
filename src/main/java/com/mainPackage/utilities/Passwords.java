package com.mainPackage.utilities;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Passwords
{
	// Define the BCrypt workload to use when generating password hashes. 10-31 is a valid value.
	private static int workload = 12;
	
	/**
	 * generate a string representing an account password
	 * 
	 * @param password_plaintext The account's plaintext password as provided during account creation,
	 *			     or when changing an account's password.
	 *
	 * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
	 */
	
	public static String hashPassword(String password_plaintext) 
	{
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}
	
	/**
	 * This method can be used to verify a computed hash from a plaintext (e.g. during a login
	 * request) with that of a stored hash from a database. The password hash from the database
	 * must be passed as the second variable.
	 * @param password_plaintext The account's plaintext password, as provided during a login request
	 * @param stored_hash The account's stored password hash, retrieved from the authorization database
	 * @return boolean - true if the password matches the password of the stored hash, false otherwise
	 */
	public static boolean checkPassword(String password_plaintext, String stored_hash) 
	{
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}


}
