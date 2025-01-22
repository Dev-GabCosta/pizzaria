package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.CustomerDto;
import com.zup.pizzaria.models.Customer;
import com.zup.pizzaria.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CostumerController {
	private final CustomerService customerService;

	public CostumerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<CustomerDto> createClient(@Valid @RequestBody CustomerDto  customerDto) {
		CustomerDto createdCustomer = customerService.createClient(customerDto);
		URI location = URI.create(String.format("/clientes/%d", createdCustomer.getId()));
		return ResponseEntity.created(location).body(createdCustomer);
	}

	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllClients() {
		List<CustomerDto> clients = customerService.showClients();
		return ResponseEntity.ok(clients);
	}

}
