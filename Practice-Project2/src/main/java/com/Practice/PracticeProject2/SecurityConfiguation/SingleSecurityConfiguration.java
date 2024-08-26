package com.Practice.PracticeProject2.SecurityConfiguation;

import com.Practice.PracticeProject2.Repositories.UserRepository;
import com.Practice.PracticeProject2.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SingleSecurityConfiguration
{
    private  UserRepository userRepository;

    private CustomUserDetailsService userDetailsService;

    public SingleSecurityConfiguration(CustomUserDetailsService userDetailsService)
    {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    @Autowired
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance(); }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }




    @Bean
    @Autowired
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf((csrf) -> csrf.disable());
        http    .authorizeHttpRequests((authorize) -> authorize

                        .requestMatchers("/admin", "/admin/managerLogin", "/admin/managerError").permitAll()
                        .requestMatchers( "/", "/user/index", "/user/error").permitAll()
                        .requestMatchers("/CSS/**").permitAll()
                        .requestMatchers("/IMAGES/**").permitAll()
                        .requestMatchers("/JAVASCRIPT/**").permitAll()
                        .requestMatchers("/admin/managerHome").hasRole("ADMIN")
                        .requestMatchers("/user/home").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()

        )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/admin/managerLogin.html").permitAll()
                                .loginProcessingUrl("/admin/managerLogin").permitAll()
                                .defaultSuccessUrl("/admin/managerHome", true)
                                .failureUrl("/admin/managerError").permitAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/user/index.html").permitAll()
                                .loginProcessingUrl("/user/index").permitAll()
                                .defaultSuccessUrl("/user/home", true)
                                .failureUrl("/user/error").permitAll()

                )
                .logout(logout -> logout
                        .logoutUrl("/admin/managerLogout?error=true").permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/user/logout?error=true").permitAll()
                );
        return http.build();
    }
}
