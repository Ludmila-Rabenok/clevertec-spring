package ru.clevertec.course.service;

import ru.clevertec.course.dto.CarShowroomDto;

import java.util.List;

public interface CarShowroomService {
    List<CarShowroomDto> findAll();

    CarShowroomDto findById(Long id);

    CarShowroomDto save(CarShowroomDto carShowroomDto);

    void remove(CarShowroomDto carShowroomDto);

    CarShowroomDto update(CarShowroomDto carShowroomDto);
}