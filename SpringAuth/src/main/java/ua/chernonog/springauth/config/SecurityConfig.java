package ua.chernonog.springauth.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


//Главный класс , где мы настраиваем Spring Security. В нем мы настраивем автентификацию, авторизацию т.д.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    //Настраивает аутентификацию
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider();

    }

}
