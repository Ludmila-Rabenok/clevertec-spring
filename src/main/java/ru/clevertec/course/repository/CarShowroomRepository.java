package ru.clevertec.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.course.entity.CarShowroom;

public interface CarShowroomRepository extends JpaRepository<CarShowroom, Long> {}