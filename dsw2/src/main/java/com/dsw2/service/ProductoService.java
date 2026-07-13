package com.dsw2.service;

import com.dsw2.model.Producto;
import com.dsw2.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto buscarPorId(int id) {
        return repo.findById(id).orElseThrow();
    }

    public Producto guardar(Producto p) {
        return repo.save(p);
    }

    public Producto actualizar(int id, Producto p) {
        Producto existente = buscarPorId(id);
        existente.setNombre(p.getNombre());
        existente.setDescripcion(p.getDescripcion());
        existente.setPrecio(p.getPrecio());
        existente.setStock(p.getStock());
        return repo.save(existente);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }
}