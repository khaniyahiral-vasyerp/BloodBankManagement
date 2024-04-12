package blood.BloodManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class CustomSuccessHandler {
    @Autowired
    private CustomSuccessHandler customSuccessHandler;
    @Autowired
    private GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /* @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf(c -> c.disable())
                 .authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers("/", "/shop/**", "/forgotPassword", "/register")
                         .permitAll()
                         .requestMatchers("/admin/**").hasRole("ADMIN")
                         .anyRequest()
                         .authenticated())
                 .formLogin(from -> from.loginPage("/login")
                         .permitAll()
                         .failureUrl("/login?error=true")
                         .defaultSuccessUrl("/")
                         .usernameParameter("email")
                         .passwordParameter("password")
                         .permitAll())

                 .oauth2Login(from -> from.loginPage("/login")
                         .successHandler("googleOAuth2SucessHandler"))
                 .logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
                         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                         .logoutSuccessUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll());
         return http.build();





        /*  http.csrf(Customizer.withDefaults())
                 .authorizeRequests(authorizeRequests -> authorizeRequests
                         .requestMatchers("/", "/shop/**", "/forgotpassword", "/register/**")
                         .permitAll()
                         .requestMatchers("/admin/**").hasRole("ADMIN")
                         .anyRequest()
                         .authenticated())
                         .formLogin(formLogin ->formLogin.successHandler(customSuccessHandler))
                 .logout(LogoutConfigurer::permitAll);
         return http.build();

     }*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/", "/shop/**", "/forgotPassword", "/register","/css/**","/resources/**","/static/**","/images/**","/js/**")
                        .permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                        .failureUrl("/login?error=true")
                        .defaultSuccessUrl("/")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .permitAll())
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .successHandler(googleOAuth2SuccessHandler))
                .logout(logout -> logout
                        .logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID")
                        .logoutRequestMatcher(new AndRequestMatcher(
                                new AntPathRequestMatcher("/logout"),
                                new AntPathRequestMatcher("/login"))).logoutSuccessUrl("/logout"));
        return http.build();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder authenticationBuilder) throws Exception {
        authenticationBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

}
