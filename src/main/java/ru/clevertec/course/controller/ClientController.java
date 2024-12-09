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
import ru.clevertec.course.dto.ClientDto;
import ru.clevertec.course.service.ClientService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        List<ClientDto> clientDtoList = clientService.findAll();
        return ResponseEntity.ok(clientDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable @Valid @NotBlank Long id) {
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody @Valid ClientDto clientDto) {
        ClientDto savedClientDto = clientService.save(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClientDto);
    }

    @PutMapping
    public ResponseEntity<ClientDto> update(@RequestBody @Valid ClientDto clientDto) {
        ClientDto updatedClientDto = clientService.update(clientDto);
        return ResponseEntity.ok().body(updatedClientDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody @Valid ClientDto clientDto) {
        clientService.remove(clientDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{carId}/{clientId}")
    public ResponseEntity<Void> buyCar(@PathVariable @Valid @NotBlank Long carId,
                                       @PathVariable @Valid @NotBlank Long clientId) {
        clientService.buyCar(carId, clientId);
        return ResponseEntity.noContent().build();
    }
}