package ru.orangeraze.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class FileEntityBO {

    private UUID id;

    private String contentType;

    @Lob
    private byte[] data;

    private String name;

    private Long size;

    private LocalDate date;

}