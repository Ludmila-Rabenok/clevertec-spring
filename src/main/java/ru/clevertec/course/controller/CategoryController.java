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
import ru.clevertec.course.dto.CategoryDto;
import ru.clevertec.course.service.CategoryService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categoryDtoList = categoryService.findAll();
        return ResponseEntity.ok(categoryDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable @Valid @NotBlank Long id) {
        CategoryDto categoryDto = categoryService.findById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto savedCategoryDto = categoryService.save(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoryDto);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto updatedCategoryDto = categoryService.update(categoryDto);
        return ResponseEntity.ok().body(updatedCategoryDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody @Valid CategoryDto categoryDto) {
        categoryService.remove(categoryDto);
        return ResponseEntity.noContent().build();
    }
}