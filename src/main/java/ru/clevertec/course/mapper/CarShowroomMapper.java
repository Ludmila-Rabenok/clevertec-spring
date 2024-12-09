package ru.clevertec.course.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.course.dto.CarShowroomDto;
import ru.clevertec.course.entity.CarShowroom;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarShowroomMapper {
    List<CarShowroomDto> toCarShowroomDtoList(List<CarShowroom> carShowrooms);

    List<CarShowroom> toCarShowroomList(List<CarShowroomDto> carShowroomDtoList);

    CarShowroomDto toCarShowroomDto(CarShowroom carShowroom);

    CarShowroom toCarShowroom(CarShowroomDto carShowroomDto);
}
