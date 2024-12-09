package ru.clevertec.course.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.course.dto.ClientDto;
import ru.clevertec.course.entity.Car;
import ru.clevertec.course.entity.Client;
import ru.clevertec.course.exception.NoSuchEntityException;
import ru.clevertec.course.mapper.ClientMapper;
import ru.clevertec.course.repository.CarRepository;
import ru.clevertec.course.repository.ClientRepository;
import ru.clevertec.course.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public List<ClientDto> findAll() {
        return clientMapper.toClientDtoList(clientRepository.findAll());
    }

    @Override
    @Transactional
    public ClientDto findById(Long id) {
        ClientDto clientDto = null;
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            clientDto = clientMapper.toClientDto(optional.get());
        }
        return clientDto;
    }

    @Override
    @Transactional
    public ClientDto save(ClientDto clientDto) {
        return clientMapper.toClientDto(clientRepository.save(clientMapper.toClient(clientDto)));
    }

    @Override
    @Transactional
    public void remove(ClientDto clientDto) {
        clientRepository.delete(clientMapper.toClient(clientDto));
    }

    @Override
    @Transactional
    public ClientDto update(ClientDto clientDto) {
        return clientMapper.toClientDto(clientRepository.save(clientMapper.toClient(clientDto)));
    }

    @Override
    @Transactional
    public void buyCar(Long carId, Long clientId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Car car;
        Client client;
        if (optionalCar.isPresent() && optionalClient.isPresent()) {
            car = optionalCar.get();
            client = optionalClient.get();
        } else throw new NoSuchEntityException();
        client.addCarToClient(car);
    }
}