package ru.orangeraze.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "analysis")
public class Analysis extends IdentifiableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "unit")
    private String unit;

    @Column(name = "norm")
    private String norm;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"user\"")
    private User user;
}