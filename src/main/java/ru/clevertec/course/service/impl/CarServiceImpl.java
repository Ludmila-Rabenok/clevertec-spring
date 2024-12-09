package ru.clevertec.course.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.course.dto.CarDto;
import ru.clevertec.course.entity.Car;
import ru.clevertec.course.entity.CarShowroom;
import ru.clevertec.course.exception.NoSuchEntityException;
import ru.clevertec.course.mapper.CarMapper;
import ru.clevertec.course.repository.CarRepository;
import ru.clevertec.course.repository.CarShowroomRepository;
import ru.clevertec.course.service.CarService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarShowroomRepository carShowroomRepository;
    private final CarMapper carMapper;


    @Override
    @Transactional
    public List<CarDto> findAll() {
        return carMapper.toCarDtoList(carRepository.findAll());
    }

    @Override
    @Transactional
    public CarDto findById(Long id) {
        CarDto carDto = null;
        Optional<Car> optional = carRepository.findById(id);
        if (optional.isPresent()) {
            carDto = carMapper.toCarDto(optional.get());
        }
        return carDto;
    }

    @Override
    @Transactional
    public CarDto save(CarDto carDto) {
        return carMapper.toCarDto(carRepository.save(carMapper.toCar(carDto)));
    }

    @Override
    @Transactional
    public void remove(CarDto carDto) {
        carRepository.delete(carMapper.toCar(carDto));
    }

    @Override
    @Transactional
    public CarDto update(CarDto carDto) {
        return carMapper.toCarDto(carRepository.save(carMapper.toCar(carDto)));
    }

    @Override
    @Transactional
    public void assignCarToShowroom(Long carId, Long showroomId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        Optional<CarShowroom> optionalShowroom = carShowroomRepository.findById(showroomId);
        Car car;
        CarShowroom carShowroom;
        if (optionalCar.isPresent() && optionalShowroom.isPresent()) {
            car = optionalCar.get();
            carShowroom = optionalShowroom.get();
        } else throw new NoSuchEntityException();
        carShowroom.addCarToShowroom(car);
    }
}