package diospringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class WebSecurityConfig {
  
//=================================================================
    
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
            User.withUsername("user")
                .password(passwordEncoder.encode("user123"))
                .roles("USERS")
                .build()
        );
        manager.createUser(
            User.withUsername("admin")
                .password(passwordEncoder.encode("master123"))
                .roles("MANAGERS")
                .build()
        );
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // apenas para testes
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login").permitAll()
                .requestMatchers("/users").hasAnyRole("USERS", "MANAGERS")
                .requestMatchers("/managers").hasRole("MANAGERS")
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .httpBasic(); 
        return http.build();
    }

//=================================================================
    
/*

DEPRECATED since Spring Security 6:

@Override
    protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/managers").hasAnyRole("MANAGERS")
            .antMatchers("/users").hasAnyRole("USERS","MANAGERS")
            .anyRequest().authenticated().and().formLogin();
}


 @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
           authorizedConfig -> {

               authorizedConfig.requestMatchers("/", "/login").permitAll();

               authorizedConfig.requestMatchers("/users").hasAuthority("USERS");

               authorizedConfig.requestMatchers("/users").hasAnyRole("MANAGERS");

               authorizedConfig.requestMatchers("/managers").hasAuthority("MANAGERS");}).formLogin();

        return http.build();
    }

   */


}
    
