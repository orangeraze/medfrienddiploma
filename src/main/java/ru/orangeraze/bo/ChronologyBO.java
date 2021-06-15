package ru.orangeraze.bo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ChronologyBO {

    private String disease;

    private String text;

    private LocalDate startdate;

    private LocalDate enddate;

}