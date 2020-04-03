package fr.iutparis8.CSID.backSIVoc.Entités;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;

@SuppressWarnings("serial")
@Entity
@Table(name="utilisateur")
public class UtilisateurEntity implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	@NotNull
	private String username;
	
	@Column(name="password")
	@NotNull
	private String password;

	@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    //@Cascade(value = CascadeType.REMOVE)
    @JoinTable(
            indexes = {@Index(name = "INDEX_USER_ROLE", columnList = "id_user")},
            name = "roles",
            joinColumns = @JoinColumn(name = "id_user")
    )
	
	@Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<RoleEnum> roles;
	
	@Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    
    
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public void setNom(String nom) {
		this.username=nom;
	}
	public UtilisateurEntity() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.roles = Collections.singletonList(RoleEnum.UTILISATEUR);
    }
	public UtilisateurEntity(String username, String password, String firstname, String lastname, Collection<RoleEnum> roles) {
        //String username, String password, String firstname, String lastname, Collection<RoleEnum> roles
		this.username = username;
        this.password = password;
//        this.firstname = firstname;
//        this.lastname = lastname;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(getRoles().stream()
                .map(Enum::name).collect(Collectors.toList()));
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

	@SuppressWarnings("null")
	private Collection<RoleEnum> getRoles() {
    	Collection<RoleEnum> c = null;
    	c.add(RoleEnum.UTILISATEUR);
    	c.add(RoleEnum.ADMINISTRATEUR);
    	c.add(RoleEnum.MODERATEUR);
		return c;
	}
	
	
	
	public void setPassword(String password) {
        if (!password.isEmpty()) {
            this.password = password;
        }
    }
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.username;
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
	
}
