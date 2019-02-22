package com.htc.par.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.htc.par.service.impl.AppUserDetailService;

@Configuration
public class ParSecurityConfiguration extends  WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthenticationProvider());
		super.configure(auth);
	}

	 @Bean
		public DaoAuthenticationProvider getAuthenticationProvider() {
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setUserDetailsService(getAppUserDetailService());
			provider.setPasswordEncoder(getPasswordEncoder());
			return provider;
		}

	 @Bean
		public PasswordEncoder getPasswordEncoder() {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			return passwordEncoder;
		}
		
		@Bean
	    public AppUserDetailService getAppUserDetailService() {
	    	return new AppUserDetailService();
	    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
			//.antMatchers("/login").permitAll()
			//.antMatchers("/skillForm").hasRole("ADMIN")
			/*.antMatchers("/customerForm").hasRole("EDITOR")
			.antMatchers("/viewCustomerForm").hasRole("USER")
			.antMatchers("/policyForm").hasAnyRole("ADMIN","EDITOR")
			.antMatchers("/claimForm").hasRole("ADMIN")*/
			.anyRequest()
			.authenticated()
            .and().csrf().disable()
            .formLogin()
            	.loginPage("/login")
            	.failureUrl("/login?error=true")
            	.usernameParameter("userName")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/home")
            	.and()
            	.logout()
            		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            		.logoutSuccessUrl("/login?logout=true")
            		.and()
            		.exceptionHandling()
            	.accessDeniedPage("/Access_Denied");
	}
	
	

}
