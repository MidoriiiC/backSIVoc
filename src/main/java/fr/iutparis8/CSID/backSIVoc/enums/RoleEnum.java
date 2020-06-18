package fr.iutparis8.CSID.backSIVoc.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority{
	ROLE_UTILISATEUR,
	ROLE_MODERATEUR,
    ROLE_ADMINISTRATEUR,
    ROLE_BENEVOLE,
    ROLE_PRETRE;

	@Override
	public String getAuthority() {
		return this.toString();
	}
}
