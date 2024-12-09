package ru.clevertec.course.service;

import ru.clevertec.course.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto findById(Long id);

    CategoryDto save(CategoryDto categoryDto);

    void remove(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);
}