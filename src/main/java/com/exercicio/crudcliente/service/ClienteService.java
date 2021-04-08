package com.exercicio.crudcliente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercicio.crudcliente.dto.ClientDTO;
import com.exercicio.crudcliente.entities.Client;
import com.exercicio.crudcliente.repositories.ClientRepository;
import com.exercicio.crudcliente.service.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);

		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new ClientDTO(entity);
	}

}
