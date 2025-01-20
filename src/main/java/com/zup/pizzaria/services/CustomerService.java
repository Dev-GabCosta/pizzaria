package com.example.Pizzaria.services;

import com.example.Pizzaria.dtos.CustomerDto;
import com.example.Pizzaria.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public CustomerDto createClient(com.example.Pizzaria.models.Customer customer) {
		customerRepository.save(customer);
		return new CustomerDto(customer.getName(), customer.getEmail());
	}

	public List<CustomerDto> showClients() {
		return customerRepository.findAll()
				       .stream()
				       .map(customer -> new CustomerDto(
						       customer.getName(),
						       customer.getEmail()
				       ))
				       .collect(
						       Collectors.toList()
				       );
	}

}
