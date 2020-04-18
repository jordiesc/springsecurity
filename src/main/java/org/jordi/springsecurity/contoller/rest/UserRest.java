package org.jordi.springsecurity.contoller.rest;

import org.jordi.springsecurity.model.Usuario;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class UserRest {

	@PreAuthorize("hasAuthority('POLICY_1')")
	@GetMapping("/current")
	Usuario getCurrenUser(Authentication authentication) {
		Usuario usuario= new Usuario();
		authentication.getAuthorities().stream().forEach(System.out::print);
		usuario.setName(authentication.getName());
		return usuario;

	}
	
}
