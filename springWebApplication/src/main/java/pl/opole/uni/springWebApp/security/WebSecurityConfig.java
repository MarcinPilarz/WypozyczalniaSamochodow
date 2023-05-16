package pl.opole.uni.springWebApp.security;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

//@Configuration
//@EnableWebSecurity
//@Order(2)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/login", "/register", "/css/**", "/samochod").permitAll()
//                .anyRequest().authenticated();
//                //.and()
//                //.formLogin()
//                //.loginPage("/login")
//                //.defaultSuccessUrl("/")
//                //.and()
//                //.logout()
//                //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                //.logoutSuccessUrl("/login?logout")
//                //.invalidateHttpSession(true)
//                //.deleteCookies("JSESSIONID");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT u.username, r.name FROM users u JOIN user_role ur ON u.id = ur.user_id JOIN roles r ON ur.role_id = r.id WHERE u.username = ?")
//                .passwordEncoder(passwordEncoder);
//    }
//
//    @Bean
//    @Primary
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
