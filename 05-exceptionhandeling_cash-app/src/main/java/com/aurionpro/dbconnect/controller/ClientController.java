package com.aurionpro.dbconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.dbconnect.dto.PageRespose;
import com.aurionpro.dbconnect.entity.Client;
import com.aurionpro.dbconnect.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("clientapp")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping("client")
    public ResponseEntity<PageRespose<Client>> getAllClients(@RequestParam(required = false) String companyName, @RequestParam int pageNo, @RequestParam int pageSize) {
        if (companyName != null) {
            return ResponseEntity.ok(clientService.getAllClientsByCompanyName(companyName, pageNo, pageSize));
        }
        return ResponseEntity.ok(clientService.getAllClients(pageNo, pageSize));
    }

    @GetMapping("client/{clientId}")
    public Client getClientById(@PathVariable int clientId) {
        return clientService.getClientById(clientId);
    }

    @PostMapping("client")
    public String addClient(@Valid @RequestBody Client client) {
        // TODO: process POST request
        clientService.addClient(client);
        return "added";
    }

    @PutMapping("client")
    public String updateClient(@RequestBody Client client) {
        // TODO: process PUT request
        clientService.updateClient(client);
        return "Updated";
    }

    @DeleteMapping("client/{clientId}")
    public String deleteClient(@PathVariable int clientId) {
        clientService.deleteClient(clientId);
        return "deleted";
    }
}
