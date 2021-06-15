package ru.orangeraze.bo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnalysisBO {

    private String name;

    private String value;

    private String unit;

    private String minnorm;

    private String maxnorm;

    private LocalDate date;

}
