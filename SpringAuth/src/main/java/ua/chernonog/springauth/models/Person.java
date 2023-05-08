package ua.chernonog.springauth.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person")
@Getter
@Setter
@AllArgsConstructor
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message="Это поле не может быть пустым")
    @Min(value = 2,message = "Миниманая длина имени должна быть минимум 2 символа")
    @Column (name="username")
    private String userName;
}
