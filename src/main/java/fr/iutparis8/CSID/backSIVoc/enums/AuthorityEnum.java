package fr.iutparis8.CSID.backSIVoc.enums;

import org.springframework.security.core.GrantedAuthority;

public enum AuthorityEnum implements GrantedAuthority{
	AUTHORITY_UTILISATOR,
	AUTHORITY_MODERATOR,
    AUTHORITY_ADMINISTRATOR,
    AUTHORITY_VOLUNTEER,
    AUTHORITY_PRIEST;

	@Override
	public String getAuthority() {
		return this.toString();
	}
}
