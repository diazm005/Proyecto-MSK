package com.dsw2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fakestore", url = "https://fakestoreapi.com")
public interface FakeStoreClient {

    @GetMapping("/products")
    List<FakeProducto> getAllProductos();

    @GetMapping("/products/{id}")
    FakeProducto getProductoById(@PathVariable int id);
}