package ru.clevertec.course.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.course.dto.CarShowroomDto;
import ru.clevertec.course.entity.CarShowroom;
import ru.clevertec.course.mapper.CarShowroomMapper;
import ru.clevertec.course.repository.CarShowroomRepository;
import ru.clevertec.course.service.CarShowroomService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarShowroomServiceImpl implements CarShowroomService {
    private final CarShowroomRepository carShowroomRepository;
    private final CarShowroomMapper carShowroomMapper;

    @Override
    @Transactional
    public List<CarShowroomDto> findAll() {
        return carShowroomMapper.toCarShowroomDtoList(carShowroomRepository.findAll());
    }

    @Override
    @Transactional
    public CarShowroomDto findById(Long id) {
        CarShowroomDto carShowroomDto = null;
        Optional<CarShowroom> optional = carShowroomRepository.findById(id);
        if (optional.isPresent()) {
            carShowroomDto = carShowroomMapper.toCarShowroomDto(optional.get());
        }
        return carShowroomDto;
    }

    @Override
    @Transactional
    public CarShowroomDto save(CarShowroomDto carShowroomDto) {
        return carShowroomMapper.toCarShowroomDto(carShowroomRepository
                .save(carShowroomMapper.toCarShowroom(carShowroomDto)));
    }

    @Override
    @Transactional
    public void remove(CarShowroomDto carShowroomDto) {
        carShowroomRepository
                .delete(carShowroomMapper.toCarShowroom(carShowroomDto));
    }

    @Override
    @Transactional
    public CarShowroomDto update(CarShowroomDto carShowroomDto) {
        return carShowroomMapper.toCarShowroomDto(carShowroomRepository
                .save(carShowroomMapper.toCarShowroom(carShowroomDto)));
    }
}