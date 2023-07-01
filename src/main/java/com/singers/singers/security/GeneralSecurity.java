package com.singers.singers.security;

import com.singers.singers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Controller
@EnableWebSecurity
public class GeneralSecurity {

    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService, BCryptPasswordEncoder encoder) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(encoder); //set the password encoder - bcrypt
        return auth;
        // DaoAuthenticationProvider is an AuthenticationProvider implementation that uses a UserDetailsService and PasswordEncoder to authenticate a username and password.
    }

    /*
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        theUserDetailsManager.setUsersByUsernameQuery("select id, username, password, enabled from members where username=?");

        theUserDetailsManager
                .setAuthoritiesByUsernameQuery("select user_id, name from role where user_id=?");

        return theUserDetailsManager;
    }
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/singers/addSingerForm")
                        .hasRole("ADMIN")
                        .requestMatchers("/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
        );

        http.formLogin(form -> form.loginPage("/loginPage").loginProcessingUrl("/authenticateTheUser"));

        // if someone can't access to the page, this will be shown
        http.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

        http.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());

        return http.build();
    }


    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails sezarfen = User.builder()
                .username("sezarfen")
                .password("{noop}test123")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(sezarfen);
    }
     */
}
