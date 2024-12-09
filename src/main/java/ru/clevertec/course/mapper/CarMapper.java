package ru.clevertec.course.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.course.dto.CarDto;
import ru.clevertec.course.entity.Car;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CarShowroomMapper.class})
public interface CarMapper {
    List<CarDto> toCarDtoList(List<Car> cars);

    List<Car> toCarList(List<CarDto> carDtoList);

    CarDto toCarDto(Car car);

    Car toCar(CarDto carDto);
}
