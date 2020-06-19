package fr.iutparis8.CSID.backSIVoc.model;

public class User{

	private int id;
	private String name;
	private String firstname;
	private String email;
	private String password;
	private String authority;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getAuthority() {
		return this.authority;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
