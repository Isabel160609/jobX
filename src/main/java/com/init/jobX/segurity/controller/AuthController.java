package com.init.jobX.segurity.controller;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.init.jobX.segurity.dto.JwtDto;
import com.init.jobX.segurity.dto.LoginUser;
import com.init.jobX.segurity.dto.NewUser;
import com.init.jobX.segurity.entity.Rol;
import com.init.jobX.segurity.entity.User;
import com.init.jobX.segurity.enums.RolName;
import com.init.jobX.segurity.jwt.JwtProvider;
import com.init.jobX.segurity.service.RolService;
import com.init.jobX.segurity.service.UserService;
import com.init.jobX.util.Mensage;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	 	@Autowired(required=true)
	    PasswordEncoder passwordEncoder;

	    @Autowired(required=true)
	    AuthenticationManager authenticationManager;

	    @Autowired(required=true)
	    UserService userService;

	    @Autowired(required=true)
	    RolService rolService;

	    @Autowired(required=true)
	    JwtProvider jwtProvider;

	    @PostMapping("/signup")
	    public ResponseEntity<?> nuevo( @Valid @RequestBody NewUser newUser, BindingResult bindingResult){
//	        if(bindingResult.hasErrors())
//	            return new ResponseEntity(new Mensage("wrong fields or invalid email"), HttpStatus.BAD_REQUEST);
	        if(bindingResult.hasFieldErrors("email"))
	            return new ResponseEntity<>(new Mensage("invalid email"), HttpStatus.BAD_REQUEST);
	        if(bindingResult.hasFieldErrors("password"))
	            return new ResponseEntity<>(new Mensage("invalid password"), HttpStatus.BAD_REQUEST);
	        if(userService.existsByNombreUsuario(newUser.getUserName()))
	            return new ResponseEntity<>(new Mensage("that name already exists"), HttpStatus.BAD_REQUEST);
	        if(userService.existsByEmail(newUser.getEmail()))
	            return new ResponseEntity<>(new Mensage("that email already exists"), HttpStatus.BAD_REQUEST);
	        User usuario =
	                new User(newUser.getUserName(), newUser.getEmail(),
	                        passwordEncoder.encode(newUser.getPassword()));
	        Set<Rol> roles = new HashSet<>();
	        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
	        if(newUser.getRoles().contains("admin"))
	            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
	        usuario.setRoles(roles);
	        userService.save(usuario);
	        return new ResponseEntity<>(new Mensage("saved user"), HttpStatus.CREATED);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<JwtDto> login( @RequestBody LoginUser loginUser, BindingResult bindingResult){
	        if(bindingResult.hasErrors())  
	            return new ResponseEntity(new Mensage("wrong fields"), HttpStatus.BAD_REQUEST);
	        Authentication authentication =
	                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = jwtProvider.generateToken(authentication);
	        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
	        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
	        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
	    }
	}
