package ru.clevertec.course.dto;

import jakarta.validation.constraints.NotBlank;

public class CarShowroomDto {
    Long id;
    @NotBlank String name;
    @NotBlank String address;
}
