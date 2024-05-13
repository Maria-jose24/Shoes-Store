package com.example.shoestore.interfacesService;

import java.util.List;

import com.example.shoestore.model.cliente;

public interface IclienteService {


    String save(cliente cliente);

    List<cliente> findAll();

    cliente findOne(String id);

    void delete(String id);

    void update(String id, cliente clienteUpdate);
}

