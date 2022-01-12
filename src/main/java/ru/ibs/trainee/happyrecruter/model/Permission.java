package ru.ibs.trainee.happyrecruter.model;

public enum Permission {

	CARD_READ("card:read"),
	CARD_WRITE("card:write");
	
	private final String permission;

	private Permission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	
	
}
