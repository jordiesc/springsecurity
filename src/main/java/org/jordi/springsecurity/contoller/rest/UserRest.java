package org.jordi.springsecurity.contoller.rest;

import org.jordi.springsecurity.model.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class UserRest {

	@GetMapping("/current")
	Usuario getCurrenUser(Authentication authentication) {
		Usuario usuario= new Usuario();
		usuario.setName(authentication.getName());
		return usuario;

	}
	
}
