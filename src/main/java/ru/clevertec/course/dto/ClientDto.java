package ru.clevertec.course.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Set;

public class ClientDto {
    Long id;
    @NotBlank String name;
    Set<String> contacts;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate registration;
}
