package fr.iutparis8.CSID.backSIVoc.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority{
	UTILISATEUR,
	MODERATEUR,
    ADMINISTRATEUR;

	@Override
	public String getAuthority() {
		return this.toString();
	}
}
