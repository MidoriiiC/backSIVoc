package fr.iutparis8.CSID.backSIVoc.Entités;

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

import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;

@SuppressWarnings("serial")
@Entity
@Table(name = "utilisateur")
public class UtilisateurEntity implements Serializable , UserDetails{
	
	public UtilisateurEntity(){
	}
	
	private static Collection<? extends GrantedAuthority> getDefaultAuthority() {
		Collection<RoleEnum> auth = new ArrayList<RoleEnum>();
		auth.add(RoleEnum.UTILISATEUR);
		return auth;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", nullable = false)
	@NotNull
	private String username;

	@Column(name = "password", nullable = false)
	@NotNull
	private String password;

	//nullable = false
	@Column(name = "authorities")
	@Enumerated(EnumType.STRING)
	private RoleEnum role;

	@Column(name = "account_non_locked")
	private boolean accountNonLocked;

	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "account_non_expired")
	private boolean accountNonExpired;

	public Integer getId() {
		return this.id;
	}
	
	public RoleEnum getRole() {
		return role;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String nom) {
		this.username = nom;
	}

	public void setPassword(String mdp) {
		this.password = mdp;
	}
	
	public void setRole(RoleEnum r) {
		this.role=r;
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

	public UtilisateurEntity orElseThrow(Object object) {
		return null;
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

	
}
