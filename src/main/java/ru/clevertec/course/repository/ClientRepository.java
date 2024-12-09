package ru.clevertec.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.course.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {}