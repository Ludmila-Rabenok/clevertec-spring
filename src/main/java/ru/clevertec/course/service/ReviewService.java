package ru.clevertec.course.service;

import ru.clevertec.course.dto.AddReviewDto;
import ru.clevertec.course.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    ReviewDto findById(Long id);

    ReviewDto save(ReviewDto reviewDto);

    void remove(ReviewDto reviewDto);

    ReviewDto update(ReviewDto reviewDto);

    void addReview(Long clientId, Long carId, AddReviewDto addReviewDto);
}
