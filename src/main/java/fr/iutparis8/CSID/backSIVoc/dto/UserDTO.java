package fr.iutparis8.CSID.backSIVoc.dto;

public class UserDTO {

	private int id;
	private String name;
	private String firstname;
	private String email;
	private String password;
	private String authority;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UserDTO() {
	}

	public UserDTO(int id2) {
		this.id = id2;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String string) {
		this.authority = string;
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
