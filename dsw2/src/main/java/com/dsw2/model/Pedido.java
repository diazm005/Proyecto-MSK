package com.dsw2.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fecha;
    private String estado;
    private double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {}

    public Pedido(int id, LocalDateTime fecha, String estado, double total, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
    }

    public int getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public double getTotal() { return total; }
    public Cliente getCliente() { return cliente; }

    public void setId(int id) { this.id = id; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setTotal(double total) { this.total = total; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}