package com.aurionpro.mapping.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aurionpro.mapping.dto.ClientDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.entity.Client;
import com.aurionpro.mapping.repository.ClientRepository;
import com.aurionpro.mapping.service.ClientService;
import com.aurionpro.mapping.util.EntityToDTOConverter;
import com.aurionpro.mapping.util.DTOToEntityConverter;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(EntityToDTOConverter::convertToClientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PageResponse<ClientDTO> getClients(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Client> clientsPage = clientRepository.findAll(pageable);
        List<ClientDTO> content = clientsPage.getContent().stream()
                .map(EntityToDTOConverter::convertToClientDTO)
                .collect(Collectors.toList());
        return new PageResponse<>(clientsPage.getTotalPages(), clientsPage.getSize(), clientsPage.getTotalElements(), clientsPage.isLast(), content);
    }

    @Override
    public ClientDTO getClientById(int clientId) {
        return clientRepository.findById(clientId)
                .map(EntityToDTOConverter::convertToClientDTO)
                .orElse(null);
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = DTOToEntityConverter.convertToClient(clientDTO);
        return EntityToDTOConverter.convertToClientDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = DTOToEntityConverter.convertToClient(clientDTO);
        return EntityToDTOConverter.convertToClientDTO(clientRepository.save(client));
    }

    @Override
    public void deleteClient(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
