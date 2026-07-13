package com.dsw2.service;

import com.dsw2.model.Pedido;
import com.dsw2.model.Producto;
import com.dsw2.repository.PedidoRepository;
import com.dsw2.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepo;
    private final ProductoRepository productoRepo;

    public PedidoService(PedidoRepository pedidoRepo, ProductoRepository productoRepo) {
        this.pedidoRepo = pedidoRepo;
        this.productoRepo = productoRepo;
    }

    public List<Pedido> listar() {
        return pedidoRepo.findAll();
    }

    public Pedido buscarPorId(int id) {
        return pedidoRepo.findById(id).orElseThrow();
    }

    
    public Pedido guardar(Pedido pedido) {
        Pedido savedPedido = pedidoRepo.save(pedido);

        
        Thread threadProcesar = new Thread(() -> {
            System.out.println("[Thread] Procesando pedido ID: " + savedPedido.getId());
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[Thread] Pedido ID: " + savedPedido.getId() + " procesado correctamente");
        });

        threadProcesar.start();
        return savedPedido;
    }

    public void eliminar(int id) {
        pedidoRepo.deleteById(id);
    }
}