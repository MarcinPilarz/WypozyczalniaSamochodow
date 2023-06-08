package pl.opole.uni.springWebApp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.services.UzytkownikService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UzytkownikService uzytkownikService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{	
		auth.userDetailsService(uzytkownikService);
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
		.cors()
		.and()
		.httpBasic()
		.and()
		.csrf().disable()
		.authorizeRequests()
		//.antMatchers(HttpMethod.POST, "/login").hasRole("USER")
        .antMatchers(HttpMethod.GET, "/klienci").hasRole("ADMIN")
		
        .antMatchers("/samochod", "/model", "/rejestracjaUzytkownika","/login", "klienci", "/login/{userId}" ).permitAll()
      //  .anyRequest().authenticated()
        //.and()
       // .formLogin()
//            .loginPage("/login") // Własna strona logowania
//            .defaultSuccessUrl("/") // Przekierowanie po udanym logowaniu
//            .permitAll()
        .and()
        .logout()
            .logoutUrl("/logout")
           .permitAll();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void establishUsers()
//	{
//		uzytkownikService.saveUser(new User("michal", passwordEncoder().encode("michal"), "ROLE_USER"));
//		uzytkownikService.saveUser(new User("admin2", passwordEncoder().encode("admin2"), "ROLE_ADMIN"));
//		uzytkownikService.saveUser(new User("jan", passwordEncoder().encode("jan"), "ROLE_MODERATOR"));
//		uzytkownikService.saveUser(new User("kuba", passwordEncoder().encode("kuba"), "ROLE_USER"));
//	}
}
