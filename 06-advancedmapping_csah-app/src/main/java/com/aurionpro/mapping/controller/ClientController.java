package com.aurionpro.mapping.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aurionpro.mapping.dto.ClientDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/page")
    public PageResponse<ClientDTO> getClients(@RequestParam int pageNo, @RequestParam int pageSize) {
        return clientService.getClients(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable int id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }

    @PutMapping
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }
}