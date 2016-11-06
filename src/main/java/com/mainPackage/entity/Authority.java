package com.mainPackage.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AUTHORITY" , uniqueConstraints=@UniqueConstraint(columnNames={"NAME"}))
public class Authority
{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    //@Enumerated(EnumType.STRING)
    private String name;

    //@ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    //private List<User> users;
    
    public Authority()
	{
		
	}
    
	public Authority(String name)
	{
		super();
		this.name = name;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<User> getUsers() 
//	{
//		return users;
//	}

//	public void setUsers(List<User> users) 
//	{
////		if(this.users == null)
////			this.users = new ArrayList<>(users);
////		else
//			this.users = users;
//	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    

}
