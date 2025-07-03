package com.marcos.mcp.spring_security_jwt.security;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Bean
    public JWTFilter jwtFilter() {
        return new JWTFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JWTFilter jwtFilter) throws Exception {
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()))
        .csrf(csrf -> csrf.disable())
        .cors(cors -> cors.disable())
        .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(SWAGGER_WHITELIST).permitAll()
        .requestMatchers("/h2-console/**").permitAll()
        .requestMatchers(HttpMethod.POST, "/login").permitAll()
        .requestMatchers(HttpMethod.POST, "/users").permitAll()
        .requestMatchers(HttpMethod.GET, "/users").hasAnyRole("USERS", "MANAGERS")
        .requestMatchers("/managers").hasAnyRole("MANAGERS")
        .anyRequest().authenticated()
        )
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
   
   
    //============================================================================ //
    
    //@Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.headers().frameOptions().disable();
    //     http.cors().and().csrf().disable()
    //             .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
    //             .authorizeRequests()
    //             .antMatchers(SWAGGER_WHITELIST).permitAll()
    //             .antMatchers("/h2-console/**").permitAll()
    //             .antMatchers(HttpMethod.POST,"/login").permitAll()
    //             .antMatchers(HttpMethod.POST,"/users").permitAll()
    //             .antMatchers(HttpMethod.GET,"/users").hasAnyRole("USERS","MANAGERS")
    //             .antMatchers("/managers").hasAnyRole("MANAGERS")
    //             .anyRequest().authenticated()
    //             .and()
    //             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    // }


    // =============================================================================


    // Método utilizado para substituir o método acima

    // Método para ser utilizado apenas caso meu banco seja o H2

    // @Bean //HABILITANDO ACESSAR O H2-DATABSE NA WEB
    // public ServletRegistrationBean h2servletRegistration(){
    //     ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
    //     registrationBean.addUrlMappings("/h2-console/*");
    //     return registrationBean;
    // }
    
}
