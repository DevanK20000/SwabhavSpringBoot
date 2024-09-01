package com.aurionpro.dbconnect.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.entity.Client;
import com.aurionpro.dbconnect.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Override
	public Page<Client> getAllClients(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return repository.findAll(pageable);
	}

	@Override
	public Page<Client> getAllClientsByCompanyName(String companyName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return repository.findByCompanyName(companyName, pageable);
	}

	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		client.setCreationDate(new Date(new java.util.Date().getTime()));
		repository.save(client);
	}

	@Override
	public Client getClientById(Integer clientId) {
		// TODO Auto-generated method stub
		return repository.findById(clientId).get();
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		repository.save(client);
	}

	@Override
	public void deleteClient(Integer clientId) {
		// TODO Auto-generated method stub
		repository.deleteById(clientId);
	}

}
