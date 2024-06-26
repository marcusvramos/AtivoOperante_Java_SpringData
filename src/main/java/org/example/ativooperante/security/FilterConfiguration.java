package org.example.ativooperante.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class FilterConfiguration {
    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login", "/api/usuario/create").permitAll()
                        .requestMatchers(
                                "/api/denuncia/all",
                                "/api/denuncia/{id}",
                                "/api/denuncia/create",
                                "/api/denuncia/{id}",
                                "/api/feedback/all",
                                "/api/tipo/all",
                                "/api/orgao/all",
                                "/api/denuncia/user/{id}",
                                "/api/feedback/denuncia/{id}"
                        ).hasAnyAuthority("ROLE_CIDADAO", "ROLE_ADMIN")
                        .requestMatchers("/api/orgao/**", "/api/tipo/**", "/api/usuario/**",
                                "/api/feedback/**", "/api/denuncia/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(new AccessFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
