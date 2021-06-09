package ru.orangeraze.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "appointment")
public class Appointment extends IdentifiableEntity {


    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longtitude")
    private Double longtitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"user\"")
    private User user;

}
