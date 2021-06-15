package ru.orangeraze.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class AnalysisDTO {

    @NotBlank(message = "Поле \"Название\" не может быть пустым")
    @Length(max = 250, message = "Название анализа не может быть больше 250 символов")
    private String name;

    @NotBlank(message = "Поле \"Значение\" не может быть пустым")
    @Length(max = 250, message = "Значение анализа не может быть больше 250 символов")
    private String value;

    @Length(max = 20, message = "Поле \"Единица измерения\" не может быть больше 20 символов")
    private String unit;

    @Length(max = 250, message = "Поле \"Минимальная норма\" не может быть больше 250 символов")
    private String minnorm;

    @Length(max = 250, message = "Поле \"Максимальная норма\" не может быть больше 250 символов")
    private String maxnorm;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

}
