package com.example.shoestore.Controller;

import com.example.shoestore.model.cliente;
import com.example.shoestore.service.clienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class clienteController {

    @Autowired
    private clienteService clienteService;

    @PostMapping("/agregar")
    public ResponseEntity<Object> agregarCliente(@RequestBody cliente cliente) {
        try {
            clienteService.save(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAllClientes() {
        try {
            return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findClienteById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(clienteService.findOne(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable String id) {
        try {
            clienteService.delete(id);
            return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable String id, @RequestBody cliente clienteUpdate) {
        try {
            clienteService.update(id, clienteUpdate);
            return new ResponseEntity<>(clienteUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
