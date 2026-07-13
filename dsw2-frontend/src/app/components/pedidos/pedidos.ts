import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Pedido, PedidoService } from '../../services/pedido';
import { Cliente, ClienteService } from '../../services/cliente';

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pedidos.html'
})
export class PedidosComponent implements OnInit {
  pedidos: Pedido[] = [];
  clientes: Cliente[] = [];
  form = { clienteId: '', total: 0, estado: 'PENDIENTE' };

  constructor(private service: PedidoService, private clienteService: ClienteService) {}

  ngOnInit() {
    this.cargar();
    this.clienteService.getAll().subscribe(data => this.clientes = data);
  }

  cargar() { this.service.getAll().subscribe(data => this.pedidos = data); }

  guardar() {
    if (!this.form.clienteId || !this.form.estado || !this.form.total) {
      alert('Todos los campos son obligatorios');
      return
    }
    const pedido: any = {
      fecha: new Date().toISOString(),
      estado: this.form.estado,
      total: this.form.total,
      cliente: { id: this.form.clienteId }
    };
    this.service.create(pedido).subscribe(() => {
      this.cargar();
      this.form = { clienteId: '', total: 0, estado: 'PENDIENTE' };
    });
  }

  eliminar(id: number) {
    if (confirm('¿Eliminar pedido?')) {
      this.service.delete(id).subscribe(() => this.cargar());
    }
  }
}