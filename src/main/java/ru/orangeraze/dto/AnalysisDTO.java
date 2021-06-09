package ru.orangeraze.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AnalysisDTO {

    @NotBlank(message = "Поле не может быть пустым")
    @Length(max = 250, message = "Название анализа не может быть больше 250 символов")
    private String name;

    @NotBlank(message = "Поле не может быть пустым")
    @Length(max = 250, message = "Значение анализа не может быть больше 250 символов")
    private String value;

    @Length(max = 20, message = "Поле не может быть больше 20 символов")
    private String unit;

    @Length(max = 250, message = "Поле не может быть больше 250 символов")
    private String norm;
}
