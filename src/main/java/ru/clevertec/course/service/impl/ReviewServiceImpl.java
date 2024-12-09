package ru.clevertec.course.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.course.dto.AddReviewDto;
import ru.clevertec.course.dto.ReviewDto;
import ru.clevertec.course.entity.Car;
import ru.clevertec.course.entity.Client;
import ru.clevertec.course.entity.Review;
import ru.clevertec.course.exception.NoSuchEntityException;
import ru.clevertec.course.mapper.ReviewMapper;
import ru.clevertec.course.repository.CarRepository;
import ru.clevertec.course.repository.ClientRepository;
import ru.clevertec.course.repository.ReviewRepository;
import ru.clevertec.course.service.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final ReviewMapper reviewMapper;

    @Override
    @Transactional
    public List<ReviewDto> findAll() {
        return reviewMapper.toReviewDtoList(reviewRepository.findAll());
    }

    @Override
    @Transactional
    public ReviewDto findById(Long id) {
        ReviewDto reviewDto = null;
        Optional<Review> optional = reviewRepository.findById(id);
        if (optional.isPresent()) {
            reviewDto = reviewMapper.toReviewDto(optional.get());
        }
        return reviewDto;
    }

    @Override
    @Transactional
    public ReviewDto save(ReviewDto reviewDto) {
        return reviewMapper.toReviewDto(reviewRepository
                .save(reviewMapper.toReview(reviewDto)));
    }

    @Override
    @Transactional
    public void remove(ReviewDto reviewDto) {
        reviewRepository.delete(reviewMapper.toReview(reviewDto));
    }

    @Override
    @Transactional
    public ReviewDto update(ReviewDto reviewDto) {
        return reviewMapper.toReviewDto(reviewRepository
                .save(reviewMapper.toReview(reviewDto)));
    }

    @Override
    @Transactional
    public void addReview(Long clientId, Long carId, AddReviewDto addReviewDto) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Car car;
        Client client;
        if (optionalCar.isPresent() && optionalClient.isPresent()) {
            car = optionalCar.get();
            client = optionalClient.get();
        } else throw new NoSuchEntityException();
        Review review = Review.builder()
                .car(car)
                .client(client)
                .text(addReviewDto.getText())
                .rating(addReviewDto.getRating())
                .build();
        client.addReviewToClient(review);
        car.addReviewToCar(review);
        reviewRepository.save(review);
    }
}