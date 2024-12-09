package ru.clevertec.course.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddReviewDto {
    @NotBlank String text;
    @Max(value = 5) int rating;
}
