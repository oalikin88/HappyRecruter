package ru.ibs.trainee.happyrecruter.model;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
 
	USER(Set.of(Permission.CARD_READ)),
	ADMIN(Set.of(Permission.CARD_READ, Permission.CARD_WRITE));
	
	private final Set<Permission> permissions;

	private Role(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	public Set <SimpleGrantedAuthority> getAuthorities() {
		return getPermissions()
				.stream()
				.map(e -> new SimpleGrantedAuthority(e.getPermission()))
				.collect(Collectors.toSet());
	}
	

}