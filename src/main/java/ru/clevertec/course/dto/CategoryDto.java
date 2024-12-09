package ru.clevertec.course.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {
    Long id;
    @NotBlank String name;
}
