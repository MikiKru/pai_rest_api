package com.example.pai_rest_api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration      // klasa o specyficznym znaczeniu implementująca globalne zabezpieczenia w aplikcji
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // przysłonięta z nadklasy WSCA
    // determinuje które żądania http będą wymagały autoryzacji
    // determinuje sposób logowania
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                // żądania wymagające logowania
                .antMatchers("/users/update/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/users/delete/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/example").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                // ...
                .anyRequest().permitAll()                   // wszystkie pozostałe żądania pozostają otwarte
                .and().csrf().disable()                     // wył mechanizmy csrf
                .formLogin()
                .loginPage("/login")                        // adres formularza GetMapping -> musi być w kontrolerze
                    .usernameParameter("email")             // nazwa parametru name w pierwszym inpucie
                    .passwordParameter("password")          // nazwa parametru name w drugim inpucie
                    .loginProcessingUrl("/login_process")   // adres prztwarzający dane logowania z formularze -> nie musi być mapowany w kontrolerze
                .failureUrl("/login?error=true")            // na jaki adres przekierować w przypadku błędów logowania
                .defaultSuccessUrl("/")                     // domyślne przekierowanie na adres po poprawnym zalogowaniu
                .and()
                .logout()                                   // logout - czyszczenie danych logowania
                .logoutUrl("/logout")                       // adres do wylogowania -> nie musi być mapowany w kontrolerze
                    .logoutSuccessUrl("/login");            // przekierowanie po poprawnym wylogowaniu
    }
    @Autowired
    DataSource dataSource;
    // determinuje sposób logowania na podstawie tabeli w DB
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.email,u.password,u.status FROM user u WHERE u.email=?")
                .authoritiesByUsernameQuery("SELECT u.email, u.role FROM user u WHERE u.email=?")
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
