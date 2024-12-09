package ru.clevertec.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.course.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}