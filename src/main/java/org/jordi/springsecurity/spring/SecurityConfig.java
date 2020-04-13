package org.jordi.springsecurity.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
			//	.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		//to user h2-console with security
		http.csrf().disable()
		.headers().frameOptions().disable();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("jordi")
				.password("jordi")
                .roles("USER")
                .authorities("aut1","aut2")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}