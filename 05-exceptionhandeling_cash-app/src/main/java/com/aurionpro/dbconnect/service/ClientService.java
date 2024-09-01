package com.aurionpro.dbconnect.service;

import org.springframework.data.domain.Page;

import com.aurionpro.dbconnect.dto.PageRespose;
import com.aurionpro.dbconnect.entity.Client;

public interface ClientService{
	PageRespose<Client> getAllClients(int pageNo, int pageSize);

	PageRespose<Client> getAllClientsByCompanyName(String companyName, int pageNo, int pageSize);

	void addClient(Client client);

	Client getClientById(Integer clientId);

	void updateClient(Client client);

	void deleteClient(Integer clientId);
}
