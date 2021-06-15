package ru.orangeraze.bo;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentBO {

    private LocalDateTime time;

    private String doctor;

    private Double latitude;

    private Double longitude;

}