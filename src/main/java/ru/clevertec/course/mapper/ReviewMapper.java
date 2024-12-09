package ru.clevertec.course.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.course.dto.ReviewDto;
import ru.clevertec.course.entity.Review;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CarMapper.class, ClientMapper.class})
public interface ReviewMapper {

    List<ReviewDto> toReviewDtoList(List<Review> reviews);

    List<Review> toReviewList(List<ReviewDto> reviewDtoList);

    ReviewDto toReviewDto(Review review);

    Review toReview(ReviewDto reviewDtoDto);
}
