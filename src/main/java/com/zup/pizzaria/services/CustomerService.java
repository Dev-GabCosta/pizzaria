package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.CustomerDto;
import com.zup.pizzaria.models.Customer;
import com.zup.pizzaria.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public CustomerDto createClient(CustomerDto customerDto) {
		Customer customer = new Customer(customerDto.getName(), customerDto.getEmail(), customerDto.getPhone());
		customerRepository.save(customer);
		return new CustomerDto(customer.getName(), customer.getEmail(), customer.getPhone());
	}

	public List<CustomerDto> showClients() {
		return customerRepository.findAll()
				       .stream()
				       .map(customer -> new CustomerDto(
						       customer.getName(),
						       customer.getEmail(),
						       customer.getPhone()
				       ))
				       .collect(
						       Collectors.toList()
				       );
	}

}
