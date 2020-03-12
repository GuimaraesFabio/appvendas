package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.domain.Cliente;
import com.dto.ClienteDto;
import com.repositories.ClienteRepository;
import com.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _repository;

	public List<Cliente> findAll() {
		return _repository.findAll();
	}

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = _repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public Page<Cliente> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return _repository.findAll(pageRequest);
	}

	public Cliente fromDto(ClienteDto objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
}
