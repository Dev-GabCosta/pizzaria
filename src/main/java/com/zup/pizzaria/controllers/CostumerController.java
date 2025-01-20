package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.CustomerDto;
import com.zup.pizzaria.models.Customer;
import com.zup.pizzaria.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CostumerController {
	private final CustomerService customerService;

	public CostumerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<CustomerDto> createClient(@Valid @RequestBody Customer  customer) {
		CustomerDto customerDto = customerService.createClient(customer);
		return ResponseEntity.ok(customerDto);
	}

	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllClients() {
		List<CustomerDto> clients = customerService.showClients();
		return ResponseEntity.ok(clients);
	}

}
