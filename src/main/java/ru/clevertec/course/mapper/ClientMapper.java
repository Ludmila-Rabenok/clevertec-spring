package ru.clevertec.course.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.course.dto.ClientDto;
import ru.clevertec.course.entity.Client;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    List<ClientDto> toClientDtoList(List<Client> clients);

    List<Client> toClientList(List<ClientDto> clientDtoList);

    ClientDto toClientDto(Client client);

    Client toClient(ClientDto clientDto);
}
