package ru.clevertec.course.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.course.dto.CarShowroomDto;
import ru.clevertec.course.service.CarShowroomService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/showrooms")
@RequiredArgsConstructor
public class CarShowroomController {

    private final CarShowroomService carShowroomService;

    @GetMapping
    public ResponseEntity<List<CarShowroomDto>> findAll() {
        List<CarShowroomDto> carShowroomDtoLists = carShowroomService.findAll();
        return ResponseEntity.ok(carShowroomDtoLists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarShowroomDto> findById(@PathVariable @Valid @NotBlank Long id) {
        CarShowroomDto carShowroomDto = carShowroomService.findById(id);
        return ResponseEntity.ok(carShowroomDto);
    }

    @PostMapping
    public ResponseEntity<CarShowroomDto> save(@RequestBody @Valid CarShowroomDto carShowroomDto) {
        CarShowroomDto savedCarShowroomDto = carShowroomService.save(carShowroomDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarShowroomDto);
    }

    @PutMapping
    public ResponseEntity<CarShowroomDto> update(@RequestBody @Valid CarShowroomDto carShowroomDto) {
        CarShowroomDto updatedCarShowroomDto = carShowroomService.update(carShowroomDto);
        return ResponseEntity.ok().body(updatedCarShowroomDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody @Valid CarShowroomDto carShowroomDto) {
        carShowroomService.remove(carShowroomDto);
        return ResponseEntity.noContent().build();
    }
}