package com.aurionpro.mapping.service;

import java.util.List;
import com.aurionpro.mapping.dto.ClientDTO;
import com.aurionpro.mapping.dto.PageResponse;

public interface ClientService {
    List<ClientDTO> getAllClients();
    PageResponse<ClientDTO> getClients(int pageNo, int pageSize);
    ClientDTO getClientById(int clientId);
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(int clientId);
}
