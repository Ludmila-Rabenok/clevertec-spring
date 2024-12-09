package ru.clevertec.course.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CarDto {
    Long id;
    @NotBlank String model;
    @NotBlank String brand;
    @Min(value = 1999) int year;
    @Positive double price;
    CategoryDto category;
    CarShowroomDto carShowroom;
}
