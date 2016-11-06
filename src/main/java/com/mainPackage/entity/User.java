package com.mainPackage.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User
{
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	private Long id;

	@Column(name = "USERNAME", length = 50, unique = true)
	@NotNull
	@Size(min = 4, max = 50)
	private String username;

	@Column(name = "PASSWORD", length = 100)
	@NotNull
	@Size(min = 4, max = 100)
	private String password;

	@Column(name = "FIRSTNAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String firstname;

	@Column(name = "LASTNAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String lastname;

	@Column(name = "EMAIL", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String email;

	@Column(name = "ENABLED")
	@NotNull
	private Boolean enabled;

	@Column(name = "LASTPASSWORDRESETDATE")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date lastPasswordResetDate;

	@Column(name = "AVATAR")
	private String avatar;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

	
	
	public User()
	{
	}


	public User(String username, String password, String firstname, String lastname, String email, Boolean enabled, Date lastPasswordResetDate, String avatar, List<Authority> authorities)
	{
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.avatar = avatar;
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}


	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}


	public List<Authority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
		if (!getUsername().equals(user.getUsername())) return false;
		if (getFirstname() != null ? !getFirstname().equals(user.getFirstname()) : user.getFirstname() != null)
			return false;
		if (getLastname() != null ? !getLastname().equals(user.getLastname()) : user.getLastname() != null)
			return false;
		return getEmail().equals(user.getEmail());

	}

	@Override
	public int hashCode()
	{
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + getUsername().hashCode();
		result = 31 * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
		result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
		result = 31 * result + getEmail().hashCode();
		return result;
	}
}
