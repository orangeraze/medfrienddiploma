package ru.orangeraze.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class FileResponse {
    private String id;
    private String name;
    private Long size;
    private String url;
    private String contentType;
    private LocalDate date;
}
