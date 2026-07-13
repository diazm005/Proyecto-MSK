package com.dsw2.controller;

import com.dsw2.feign.FakeProducto;
import com.dsw2.feign.FakeStoreClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  
@RequestMapping("/api/external")
public class FakeStoreController {

    private final FakeStoreClient client;

    public FakeStoreController(FakeStoreClient client) {
        this.client = client;
    }

    @GetMapping("/productos")
    public List<FakeProducto> getAll() {
        return client.getAllProductos();
    }

    @GetMapping("/productos/{id}")
    public FakeProducto getById(@PathVariable int id) {
        return client.getProductoById(id);
    }
}