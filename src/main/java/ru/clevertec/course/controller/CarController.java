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
import ru.clevertec.course.dto.CarDto;
import ru.clevertec.course.service.CarService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> findAll() {
        List<CarDto> carDtoLists = carService.findAll();
        return ResponseEntity.ok(carDtoLists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findById(@PathVariable @Valid @NotBlank Long id) {
        CarDto carDto = carService.findById(id);
        return ResponseEntity.ok(carDto);
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody @Valid CarDto carDto) {
        CarDto savedCarDto = carService.save(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarDto);
    }

    @PutMapping
    public ResponseEntity<CarDto> update(@RequestBody @Valid CarDto carDto) {
        CarDto updatedCarDto = carService.update(carDto);
        return ResponseEntity.ok().body(updatedCarDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody @Valid CarDto carDto) {
        carService.remove(carDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{carId}/{showroomId}")
    public ResponseEntity<Void> assignCarToShowroom(@PathVariable @Valid @NotBlank Long carId,
                                                    @PathVariable @Valid @NotBlank Long showroomId) {
        carService.assignCarToShowroom(carId, showroomId);
        return ResponseEntity.noContent().build();
    }
}