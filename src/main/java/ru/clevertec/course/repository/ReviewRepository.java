package ru.clevertec.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.course.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {}