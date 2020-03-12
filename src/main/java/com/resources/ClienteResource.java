package com.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Cliente;
import com.dto.ClienteDto;
import com.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService _service;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = _service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente obj = _service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<ClienteDto>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linePerPage", defaultValue = "24") Integer linePerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

		Page<Cliente> list = _service.findPage(page, linePerPage, direction, orderBy);
		Page<ClienteDto> listDto = list.map(obj -> new ClienteDto(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
