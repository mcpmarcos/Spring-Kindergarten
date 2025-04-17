package diospringsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class WebSecurityConfig {
  
    //Em memória
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) 
    throws Exception {
        auth.inMemoryAuthentication()
        .withUser("user").password("{noop}user123").roles("USERS")
        .and()
        .withUser("admin").password("{noop}master123").roles("MANAGERS");
    }        

    /*
    
     
      
    */

    //Configure Adapter
    //formLogin() deprecated since spring security 6.1

    
    /*
     

    */
    
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizedConfig -> {

            authorizedConfig.requestMatchers("/", "/login").permitAll();

            authorizedConfig.requestMatchers("/users").hasAnyAuthority("ROLE_USERS", "ROLE_MANAGERS");

            authorizedConfig.requestMatchers("/managers").hasAuthority("ROLE_MANAGERS");
         
         }).formLogin(
             form -> 
             form.loginPage("/login")
             .permitAll()
         );

        return http.build();
    }


     /*





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
    
