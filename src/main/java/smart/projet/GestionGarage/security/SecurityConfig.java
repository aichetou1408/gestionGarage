package smart.projet.GestionGarage.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private JwtAuthFilter authFilter;

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new ClientInfoClientDetailsService();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors().add().csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.POST, "/auth/*").permitAll()
        .requestMatchers(HttpMethod.GET, "/auth/*").permitAll()
        .requestMatchers(HttpMethod.PUT, "/auth/*").permitAll()
        .requestMatchers(HttpMethod.DELETE, "/auth/*").permitAll()
        .requestMatchers(HttpMethod.GET, "/swagger-ui/**", "v3/api-docs/**").permitAll()

        .and()
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, "/admin/roles").hasAuthority("list_role")
        .requestMatchers(HttpMethod.GET, "/admin/roles/{id}").hasAuthority("view_role")
        .requestMatchers(HttpMethod.POST, "/admin/roles").hasAuthority("create_role")
        .requestMatchers(HttpMethod.PUT, "/aadminroles").hasAuthority("update_role")
        .requestMatchers(HttpMethod.DELETE, "/aadminroles/{id}").hasAuthority("delete_role")

        .requestMatchers(HttpMethod.GET, "/admin/permissions").hasAuthority("list_permission")
        .requestMatchers(HttpMethod.GET, "/admin/permissions/{id}").hasAuthority("view_permission")
        .requestMatchers(HttpMethod.POST, "/admin/permissions").hasAuthority("create_permission")
        .requestMatchers(HttpMethod.PUT, "/admin/permissions").hasAuthority("update_permission")
        .requestMatchers(HttpMethod.DELETE, "/admin/permissions/{id}").hasAuthority("delete_permission")

        .requestMatchers(HttpMethod.GET, "/admin/users").hasAuthority("list_user")
        .requestMatchers(HttpMethod.POST, "/admin/update-password").hasAuthority("update_user_password")
        .requestMatchers(HttpMethod.POST, "/admin/addroletouser").hasAuthority("update_user_role")
        .requestMatchers(HttpMethod.DELETE, "/admin/users/{id}").hasAuthority("delete_user")

        .requestMatchers(HttpMethod.PUT, "/user/update-password").hasAuthority("update_user_password")
        .requestMatchers(HttpMethod.POST, "/user/reset-password").hasAuthority("update_user_password")
        .requestMatchers(HttpMethod.GET, "/user/profile").hasAuthority("get_profile")
        .requestMatchers(HttpMethod.PUT, "/user/profile").hasAuthority("update_profile")

        .requestMatchers(HttpMethod.PUT, "/api/company").hasAuthority("update_company")
        .requestMatchers(HttpMethod.POST, "/api/company").hasAuthority("create_company")
        .requestMatchers(HttpMethod.GET, "/api/company/all").hasAuthority("view_company")

        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider())
        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider 
}
