package ru.orangeraze.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "analysis")
public class Analysis extends IdentifiableEntity {

    @ManyToOne
    @JoinColumn(name = "user")
    private Analysis userAnalysis;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "unit")
    private String unit;
}