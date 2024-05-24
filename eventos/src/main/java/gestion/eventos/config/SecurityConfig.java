package gestion.eventos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import gestion.eventos.servicios.OrganizadorDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    OrganizadorDetailService uDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity HttpSecurity) throws Exception{
        HttpSecurity.authorizeHttpRequests(registry -> {
            registry.requestMatchers("/admin/**").authenticated();
            registry.anyRequest().permitAll();
        })
        .formLogin(httpSecurityFormLoginConfigurer -> { 
            httpSecurityFormLoginConfigurer
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/admin/panel");
        })
        .logout(httpSecurityLogoutConfigurer -> {
            httpSecurityLogoutConfigurer
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll();
        });
        
        return HttpSecurity.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(uDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
