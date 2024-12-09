package ru.clevertec.course.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.course.dto.CategoryDto;
import ru.clevertec.course.entity.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    List<CategoryDto> toCategoryDtoList(List<Category> categories);

    List<Category> toCategoryList(List<CategoryDto> categoryDtoList);

    CategoryDto toCategoryDto(Category category);

    Category toCategory(CategoryDto categoryDto);
}
