package ua.chernonog.springauth.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "Person")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message="Это поле не может быть пустым")
    @Size(min = 2, max =100,message = "Миниманая длина имени должна быть минимум 2 символа")
    @Column (name="username")
    private String username;

    @NotNull
    @Min(value = 1920, message="Год рождения должен быть больше чем 1920")
    @Max(value=2023, message="Год рождения не может быть больше текущего года" )
    @Column(name="year_of_birth")
    private int yearOfBirth;

    @NotNull
    @Column(name="password")
    private String password;
}
