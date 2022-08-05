package fr.m2i.spring.lesson.form.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Méthode pour config la protection des url
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login") // pour les requetes qui matchent cette URI 
                .permitAll() // Autoriser toutes les requêtes => donc pas besoin d'être connecté
                .anyRequest().authenticated() // Pour toutes les autres requêtes on demande une authentification
                .and()
                .formLogin() // On active le formulaire de login
                .loginPage("/login"); // On configure notre propre page de login plutôt qu'utiliser la page par défaut de Spring security
                
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    // Méthode pour config le mode d'authentification
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() // Authentification en mémoire donc pas de vérif en BDD
                .passwordEncoder(NoOpPasswordEncoder.getInstance()) // On ne veut que le mot de passe soit crypté
                .withUser("admin").password("admin") // On créer l'utilisateur admin => Authentication
                .roles("USER", "ADMIN") // On lui assigne les role USER et ADMIN => Authorization
                .and()
                .withUser("manager").password("manager")
                .roles("USER", "MANAGER");
                
      
                
    }

    
   
}
