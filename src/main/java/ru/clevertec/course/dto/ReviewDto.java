package ru.clevertec.course.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewDto {
    Long id;
    @NotBlank String text;
    @Max(value = 5) int rating;
    @NotNull ClientDto client;
    @NotNull CarDto car;
}
