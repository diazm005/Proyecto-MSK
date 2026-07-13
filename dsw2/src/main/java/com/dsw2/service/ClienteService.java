package com.dsw2.service;

import com.dsw2.model.Cliente;
import com.dsw2.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente buscarPorId(int id) {
        return repo.findById(id).orElseThrow();
    }

    public Cliente guardar(Cliente c) {
        return repo.save(c);
    }

    public Cliente actualizar(int id, Cliente c) {
        Cliente existente = buscarPorId(id);
        existente.setNombre(c.getNombre());
        existente.setEmail(c.getEmail());
        existente.setTelefono(c.getTelefono());
        return repo.save(existente);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }
}