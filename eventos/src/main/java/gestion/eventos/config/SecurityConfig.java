package gestion.eventos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity HttpSecurity) throws Exception{
        return HttpSecurity.authorizeHttpRequests(registry -> {
            registry.requestMatchers("/admin/**").authenticated();
            registry.anyRequest().permitAll();
        }
        )
        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
        .build();
    }
}
