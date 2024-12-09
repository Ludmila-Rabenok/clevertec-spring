package ru.clevertec.course.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.course.dto.AddReviewDto;
import ru.clevertec.course.dto.ReviewDto;
import ru.clevertec.course.service.ReviewService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    public final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> findAll() {
        List<ReviewDto> reviewDtoList = reviewService.findAll();
        return ResponseEntity.ok(reviewDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> findById(@PathVariable @Valid @NotBlank Long id) {
        ReviewDto reviewDto = reviewService.findById(id);
        return ResponseEntity.ok(reviewDto);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> save(@RequestBody @Valid @NotBlank ReviewDto reviewDto) {
        ReviewDto savedReviewDto = reviewService.save(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReviewDto);
    }

    @PutMapping
    public ResponseEntity<ReviewDto> update(@RequestBody @Valid @NotBlank ReviewDto reviewDto) {
        ReviewDto updatedReviewDto = reviewService.update(reviewDto);
        return ResponseEntity.ok().body(updatedReviewDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody @Valid @NotBlank ReviewDto reviewDto) {
        reviewService.remove(reviewDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{clientId}/{carId}")
    public ResponseEntity<Void> addReview(@PathVariable @Valid @NotBlank Long clientId,
                                          @PathVariable @Valid @NotBlank Long carId,
                                          @RequestBody @Valid AddReviewDto addReviewDto) {
        reviewService.addReview(clientId,carId,addReviewDto);
        return ResponseEntity.noContent().build();
    }
}