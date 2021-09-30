package ru.orangeraze.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDTO {

    @NotBlank(message = "Поле \"Врач\" не может быть пустым")
    @Length(max = 250, message = "Название и имя врача не могут быть больше 250 символов")
    private String doctor;

    @Length(max = 250, message = "Поле \"Адрес\" не может быть больше 250 символов")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime time;
}
