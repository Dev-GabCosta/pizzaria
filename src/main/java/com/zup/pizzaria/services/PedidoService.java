package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Customer;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.CustomerRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final CustomerRepository customerRepository;

    public PedidoService(PedidoRepository pedidoRepository, CustomerRepository customerRepository) {
        this.pedidoRepository = pedidoRepository;
        this.customerRepository = customerRepository;
    }

    public PedidoDTO criarPedido(Pedido pedido) {
        // Salva pedido
        pedidoRepository.save(pedido);

        // Obtenho cliente
        Customer customer = customerRepository
                .findById(pedido.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return new PedidoDTO(customer.getName(), customer.getEmail(), pedido.getDescricao());
    }
}
