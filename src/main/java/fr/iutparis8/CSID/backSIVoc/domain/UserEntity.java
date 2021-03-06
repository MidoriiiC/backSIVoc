package fr.iutparis8.CSID.backSIVoc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.iutparis8.CSID.backSIVoc.enums.AuthorityEnum;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class UserEntity implements Serializable, UserDetails {

	public UserEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", nullable = false)
	@NotNull
	private String username;

	@Column(name = "firstname", nullable = false)
	@NotNull
	private String firstname;

	@Column(name = "password", nullable = false)
	@NotNull
	private String password;

	@Column(name = "email", nullable = false)
	@NotNull
	private String email;

	@Column(name = "authority")
	@Enumerated(EnumType.STRING)
	private AuthorityEnum authority;

	@Column(name = "account_not_locked")
	private boolean accountNonLocked;

	@Column(name = "credentials_not_expired")
	private boolean credentialsNonExpired;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "account_not_expired")
	private boolean accountNonExpired;

	@Column(name = "token")
	private String token;

	public int getId() {
		return this.id;
	}

	public AuthorityEnum getAutority() {
		return authority;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String nom) {
		this.username = nom;
	}

	public void setPassword(String mdp) {
		this.password = mdp;
	}

	public void setAuthority(AuthorityEnum r) {
		this.authority = r;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> ls = new ArrayList<>();
		ls.add(new SimpleGrantedAuthority("ROLE_CAN_DO_WHOAMI"));
		ls.add(new SimpleGrantedAuthority("ROLE_USER"));
		return ls;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public UserEntity orElseThrow(Object object) {
		return null;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}
