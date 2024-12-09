package ru.clevertec.course.service;

import ru.clevertec.course.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAll();

    ClientDto findById(Long id);

    ClientDto save(ClientDto clientDto);

    void remove(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);

    void buyCar(Long carId, Long clientId);
}