package com.init.jobX.segurity.enums;

import java.util.stream.Stream;

public enum RolName {
    ROLE_ADMIN("admin"), ROLE_USER("user");
    
    private String tipeOfUser;

	private RolName(String tipeOfUser) {
		this.tipeOfUser = tipeOfUser;
	}
    
	
	public String getTipeOfUser() {
		return tipeOfUser;
	}


	public void setTipeOfUser(String tipeOfUser) {
		this.tipeOfUser = tipeOfUser;
	}


	public static Stream<RolName> stream() {
        return Stream.of(RolName.values()); 
	}
}
