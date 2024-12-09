package ru.clevertec.course.service;

import ru.clevertec.course.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> findAll();

    CarDto findById(Long id);

    CarDto save(CarDto carDto);

    void remove(CarDto carDto);

    CarDto update(CarDto carDto);

    void assignCarToShowroom(Long carId, Long showroomId);
}