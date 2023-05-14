package ru.stc.ebpas.crm.core.config;

import ru.stc.ebpas.crm.core.config.CorsFilter;
import ru.stc.ebpas.crm.core.config.JwtFilter;
import ru.stc.ebpas.crm.core.config.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class FilterConfigurer  extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
        private JwtProvider jwtProvider;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            JwtFilter jwtFilter = new JwtFilter(jwtProvider);
            http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
            CorsFilter corsFilter = new CorsFilter();
            http.addFilterBefore(corsFilter, JwtFilter.class);
        }

}
