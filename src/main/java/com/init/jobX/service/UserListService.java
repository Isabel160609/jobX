package com.init.jobX.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.jobX.segurity.entity.Rol;
import com.init.jobX.segurity.entity.User;
import com.init.jobX.segurity.repository.RolRepository;
import com.init.jobX.segurity.repository.UserRepository;

@Service
public class UserListService {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RolRepository rolRepository;
	
	public List<User> listUsers() {

		List<User> users = userRepository.findAll();
		for(int i=0; i<users.size();i++) {
			
			boolean admin=false;
			for(Rol x : users.get(i).getRoles()) {
			    if(x.getRolName().getTipeOfUser().equals("admin")) {
			    	admin=true;
			    }
			if( admin==true) {
				users.remove(i);
			}
			}
			
		}
		return users;
	}

}
