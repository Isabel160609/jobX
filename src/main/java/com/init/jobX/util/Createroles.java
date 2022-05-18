package com.init.jobX.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.init.jobX.segurity.entity.Rol;
import com.init.jobX.segurity.enums.RolName;
import com.init.jobX.segurity.service.RolService;



@Component
public class Createroles implements CommandLineRunner{

	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
		Rol rolAdmin=new Rol(RolName.ROLE_ADMIN);
		Rol roluser=new Rol(RolName.ROLE_USER);
		rolService.save(roluser);
		rolService.save(rolAdmin);
	}

}
