package org.jordi.springsecurity.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity(debug = true)
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
				.permitAll()
				.and()
				.httpBasic()
				.and().addFilterAfter(new CustomSampleFilter(super.authenticationManagerBean()), BasicAuthenticationFilter.class);
		//http.addFilterBefore(
		//			new CustomSampleFilter(), BasicAuthenticationFilter.class);
		//to user h2-console with security
		http.csrf().disable()
		.headers().frameOptions().disable();
		
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user1 =
			 User.withDefaultPasswordEncoder()
				.username("jordi")
				.password("jordi")
                .roles("USER")
                .authorities("POLICY_1")
				.build();
			UserDetails user2 =
			 User.withDefaultPasswordEncoder()
				.username("pepe")
				.password("pepe")
                .roles("USER")
                .authorities("POLICY_2")
				.build();		

		return new InMemoryUserDetailsManager(user1,user2);
	}
	
    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
          = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
	}
	
	
	
	@Bean("authenticationManager")
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}