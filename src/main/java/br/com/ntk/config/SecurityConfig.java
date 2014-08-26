package br.com.ntk.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	   /*
	    * Exemplo para Obter Usuarios com simulacao do BD em Memoria
	    *  auth
	    	.inMemoryAuthentication()
	        	.withUser("ntk").password("8c18ecb3-7f92-4523-8dbd-5da2c104ea5e").roles("DESENV").and()
	        	.withUser("edubossa").password("05d474da-1001-4eca-af2e-a3e7fbd9e6b4").roles("DESENV").and()
	        	.withUser("admin").password("1933a7a9-e66f-4c67-9a5a-0f0e6e96d958").roles("DESENV");*/
		
		//Autentica e autoriza os usuarios cadastrados no BD
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username,password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
		
	  }
	
	
	  protected void configure(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
		  	//Atribui o perfil de DESENV a todos os que consomen os WebServices
		  	.antMatchers("/webservice/**").access("hasRole('DESENV')") 
		  	.anyRequest().anonymous()
		  	.and().httpBasic();
	  }
	
}