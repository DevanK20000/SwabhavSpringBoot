package com.aurionpro.dbconnect.service;

import org.springframework.data.domain.Page;

import com.aurionpro.dbconnect.entity.Client;

public interface ClientService{
	Page<Client> getAllClients(int pageNo, int pageSize);

	Page<Client> getAllClientsByCompanyName(String companyName, int pageNo, int pageSize);

	void addClient(Client client);

	Client getClientById(Integer clientId);

	void updateClient(Client client);

	void deleteClient(Integer clientId);
}
