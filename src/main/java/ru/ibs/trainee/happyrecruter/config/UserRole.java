package ru.ibs.trainee.happyrecruter.config;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.google.common.collect.Sets;
import static ru.ibs.trainee.happyrecruter.config.UserPermission.*;

public enum UserRole {
		ADMIN(Sets.newHashSet(REGISTRY_READ, PROJECT_READ, PROJECT_WRITE)),
	    MANAGER(Sets.newHashSet(REGISTRY_READ, PROJECT_READ)),
	    GUEST(Sets.newHashSet(PROJECT_READ));

	private final Set<UserPermission> permissions;

	UserRole(Set<UserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<UserPermission> getPermissions() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissions;
	}
}
