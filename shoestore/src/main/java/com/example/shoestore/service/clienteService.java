package com.example.shoestore.service;

import com.example.shoestore.interfaces.Icliente;
import com.example.shoestore.interfacesService.IclienteService;
import com.example.shoestore.model.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteService implements IclienteService {

    @Autowired
    private Icliente clienteRepository;

    @Override
    public String save(cliente cliente) {
        cliente.validarCliente(); // Se realiza la validación del cliente antes de guardarlo
        clienteRepository.save(cliente);
        return cliente.getIdCliente();
    }

    @Override
    public List<cliente> findAll() {
        return (List<cliente>) clienteRepository.findAll();
    }

    @Override
    public cliente findOne(String id) {
        Optional<cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    @Override
    public void delete(String id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void update(String id, cliente clienteUpdate) {
        Optional<cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            cliente cliente = clienteOptional.get();
            // Actualizar cliente con los datos recibidos en clienteUpdate
            clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }
}
