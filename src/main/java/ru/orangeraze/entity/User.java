package ru.orangeraze.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "\"user\"")
public class User extends IdentifiableEntity {


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;

}
