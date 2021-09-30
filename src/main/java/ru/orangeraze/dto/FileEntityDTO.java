package ru.orangeraze.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class FileEntityDTO {

    @Length(max = 255, message = "Имя файла не может быть больше 255 символов")
    private String name;

    @Lob
    private byte[] data;

    private String contentType;

    private Long size;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
