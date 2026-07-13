package com.dsw2.endpoint;

import com.dsw2.model.Producto;
import com.dsw2.service.ProductoService;
import com.dsw2.webservices.*;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.List;

@Endpoint
public class ProductoEndpoint {

    private static final String NS = "http://cibertec.com/productos";

    private final ProductoService service;

    public ProductoEndpoint(ProductoService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NS, localPart = "getProductoRequest")
    @ResponsePayload
    public GetProductoResponse getProducto(@RequestPayload GetProductoRequest req) {
        Producto p = service.buscarPorId(req.getId());
        GetProductoResponse resp = new GetProductoResponse();
        resp.setProducto(toSoap(p));
        return resp;
    }

    @PayloadRoot(namespace = NS, localPart = "getAllProductosRequest")
    @ResponsePayload
    public GetAllProductosResponse getAllProductos(@RequestPayload GetAllProductosRequest req) {
        List<Producto> lista = service.listar();
        GetAllProductosResponse resp = new GetAllProductosResponse();
        lista.forEach(p -> resp.getProductos().add(toSoap(p)));
        return resp;
    }

    private com.dsw2.webservices.Producto toSoap(Producto p) {
        com.dsw2.webservices.Producto ps = new com.dsw2.webservices.Producto();
        ps.setId(p.getId());
        ps.setNombre(p.getNombre());
        ps.setDescripcion(p.getDescripcion());
        ps.setPrecio(p.getPrecio());
        ps.setStock(p.getStock());
        return ps;
    }
}