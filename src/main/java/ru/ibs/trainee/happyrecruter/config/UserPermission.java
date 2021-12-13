package ru.ibs.trainee.happyrecruter.config;

public enum UserPermission {
	    PROJECT_READ("project:read"),
	    PROJECT_WRITE("project:write"),
	    REGISTRY_READ("registry:read");
		

	private final String permission;

	UserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
