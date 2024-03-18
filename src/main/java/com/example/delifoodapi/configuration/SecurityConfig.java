package com.example.delifoodapi.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import com.example.delifoodapi.service.CustomUserDetailService;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import static org.springframework.security.config.Customizer.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	private final RsaKeyProperties jwtConfigProperties;


	public SecurityConfig(RsaKeyProperties jwtConfigProperties) {
		this.jwtConfigProperties = jwtConfigProperties;
	}
	
	@Autowired
	private CustomUserDetailService userDetailsService;
	
//	@Autowired
//	private CustomAdminService adminuserDetailsService;
	
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }
	

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .authorizeRequests(authorize -> authorize.requestMatchers("/RegisterUser","/RegisterAdminUser").permitAll().anyRequest().authenticated())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)

	            .exceptionHandling(exceptionHandling ->
	                    exceptionHandling.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
	                            .accessDeniedHandler(new BearerTokenAccessDeniedHandler()))
	       
	            .headers(headers ->
	                    headers.frameOptions().sameOrigin());

	        return http.build();
	    }
	/*
	 * This was added via PR (thanks to @ch4mpy)
	 * This will allow the /token endpoint to use basic auth and everything else uses the SFC above
	 */
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	SecurityFilterChain tokenSecurityFilterChain(HttpSecurity http) throws Exception {
		return http
				.securityMatcher(new AntPathRequestMatcher("/token"))
				 
				
			
				.authorizeHttpRequests(auth -> 
				
				auth.anyRequest().authenticated()
				)
				
				
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(AbstractHttpConfigurer::disable)
				.exceptionHandling(ex -> {
					ex.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint());
					ex.accessDeniedHandler(new BearerTokenAccessDeniedHandler());
				})
				.httpBasic(withDefaults())
				.build();
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(jwtConfigProperties.publicKey()).build();
	}

	@Bean
	JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(jwtConfigProperties.publicKey()).privateKey(jwtConfigProperties.privateKey()).build();
		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("https://localhost:3000"));
		configuration.setAllowedHeaders(List.of("*"));
		configuration.setAllowedMethods(List.of("GET"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	

    @Bean
    PasswordEncoder passwordEncoder() {
    	return NoOpPasswordEncoder.getInstance();
    }

}