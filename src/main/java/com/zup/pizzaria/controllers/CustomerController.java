package com.example.Pizzaria.controllers;

import com.example.Pizzaria.dtos.CustomerDto;
import com.example.Pizzaria.models.Customer;
import com.example.Pizzaria.services.CustomerService;
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
	public ResponseEntity<Customer> createClient(@RequestBodyCustomer  customer) {
		CustomerDto customerDto = customerService.createClient(customer);
		return ResponseEntity.ok(customerDto);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllClients() {
		List<Customer> clients = customerService.showClients();
		return ResponseEntity.ok(clients);
	}

}
