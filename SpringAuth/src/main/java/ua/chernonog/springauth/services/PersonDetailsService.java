package ua.chernonog.springauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.chernonog.springauth.models.Person;
import ua.chernonog.springauth.repositories.PeopleRepository;
import ua.chernonog.springauth.security.PersonDetails;

import java.util.Optional;


//Данный сервис предназначается только для SpringSecurity
@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person =peopleRepository.findByUsername(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("Такого пользователя не существует");

        return new PersonDetails(person.get());
    }
}
