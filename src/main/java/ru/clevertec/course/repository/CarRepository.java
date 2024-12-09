package ru.clevertec.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.course.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {}
