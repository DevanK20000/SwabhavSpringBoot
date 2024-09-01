package com.aurionpro.dbconnect.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.dto.PageRespose;
import com.aurionpro.dbconnect.entity.Client;
import com.aurionpro.dbconnect.exceptions.ClientNotFoundException;
import com.aurionpro.dbconnect.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Override
	public PageRespose<Client> getAllClients(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Client> studentPage =repository.findAll(pageable);
		PageRespose<Client> pageRespose = new PageRespose<Client>();
		pageRespose.setToatalPage(studentPage.getTotalPages());
		pageRespose.setSize(studentPage.getSize());
		pageRespose.setTotalElements(studentPage.getTotalElements());
		pageRespose.setContent(studentPage.getContent());
		pageRespose.setLastPage(studentPage.isLast());
		return pageRespose;
	}

	@Override
	public PageRespose<Client> getAllClientsByCompanyName(String companyName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Client> studentPage =repository.findByCompanyName(companyName, pageable);
		PageRespose<Client> pageRespose = new PageRespose<Client>();
		pageRespose.setToatalPage(studentPage.getTotalPages());
		pageRespose.setSize(studentPage.getSize());
		pageRespose.setTotalElements(studentPage.getTotalElements());
		pageRespose.setContent(studentPage.getContent());
		pageRespose.setLastPage(studentPage.isLast());
		return pageRespose;
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
		Optional<Client> client = repository.findById(clientId);
		if(!client.isPresent())
			throw new ClientNotFoundException();
		return client.get();
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
