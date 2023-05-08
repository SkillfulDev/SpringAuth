package ua.chernonog.springauth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.chernonog.springauth.models.Person;

import java.util.Collection;

/*
Класс обвертка над нашей сущностью Person, так как для получения пароля и логина и использования SpringSecurity нужно
реализововать данный класс. Грубо говоря нам этот класс нужен потому что мы реализовуем интерфейс UserDetails
что гарантирует для SpringSecurity соответсвие названия методов, так как в сущности(Person) поля могут иметь другое
название
 */
public class PersonDetails implements UserDetails {

    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    //Метод нужен для получние Ролей
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
