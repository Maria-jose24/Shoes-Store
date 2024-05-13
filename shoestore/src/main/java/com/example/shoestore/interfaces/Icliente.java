package com.example.shoestore.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.shoestore.model.cliente;

public interface Icliente extends CrudRepository<cliente, String> {

    @Query("SELECT c FROM cliente c WHERE "
            + "c.id_cliente LIKE %?1% OR "
            + "c.tipoDeIdentificacion LIKE %?1% OR "
            + "c.numeroDeIdentificacion LIKE %?1% OR "
            + "c.nombreCliente LIKE %?1% OR "
            + "c.apellidoCliente LIKE %?1% OR "
            + "c.telefono LIKE %?1% OR "
            + "c.direccion LIKE %?1% OR "
            + "c.ciudad LIKE %?1% OR "
            + "c.correoElectronico LIKE %?1% OR "
            + "c.estado LIKE %?1%")
    List<cliente> filtroCliente(String filtro);

    @Query("SELECT c FROM cliente c WHERE c.estado = ?1")
    List<cliente> clientesActivos(String estado);
}


