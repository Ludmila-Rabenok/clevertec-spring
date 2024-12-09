package ru.clevertec.course.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.course.dto.CategoryDto;
import ru.clevertec.course.entity.Category;
import ru.clevertec.course.mapper.CategoryMapper;
import ru.clevertec.course.repository.CategoryRepository;
import ru.clevertec.course.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    @Transactional
    public List<CategoryDto> findAll() {
        return categoryMapper.toCategoryDtoList(categoryRepository.findAll());
    }

    @Override
    @Transactional
    public CategoryDto findById(Long id) {
        CategoryDto categoryDto = null;
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            categoryDto = categoryMapper.toCategoryDto(optional.get());
        }
        return categoryDto;
    }

    @Override
    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryMapper.toCategoryDto(categoryRepository
                .save(categoryMapper.toCategory(categoryDto)));
    }

    @Override
    @Transactional
    public void remove(CategoryDto categoryDto) {
        categoryRepository.delete(categoryMapper.toCategory(categoryDto));
    }

    @Override
    @Transactional
    public CategoryDto update(CategoryDto categoryDto) {
        return categoryMapper.toCategoryDto(categoryRepository.save(categoryMapper.toCategory(categoryDto)));
    }
}