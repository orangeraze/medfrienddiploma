package ru.orangeraze.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ChronologyDTO {

    @NotBlank(message = "Поле \"Болезнь\" не может быть пустым")
    @Length(max = 250, message = "Поле \"Болезнь\" не может быть больше 250 символов")
    private String disease;

    @Length(max = 2000, message = "Длина текста не должна превышать 2000 символов")
    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enddate;

}
