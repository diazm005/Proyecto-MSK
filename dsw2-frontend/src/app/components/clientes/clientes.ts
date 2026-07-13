import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cliente, ClienteService } from '../../services/cliente';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './clientes.html'
})
export class ClientesComponent implements OnInit {
  clientes: Cliente[] = [];
  form: Cliente = { id: 0, nombre: '', email: '', telefono: '' };
  editando = false;

  constructor(private service: ClienteService) {}

  ngOnInit() { this.cargar(); }

  cargar() { this.service.getAll().subscribe(data => this.clientes = data); }

  guardar() {
    if (!this.form.nombre || !this.form.email || !this.form.telefono) {
      alert('Todos los campos son obligatorios');
      return;
    }
    if (this.editando) {
      this.service.update(this.form.id, this.form).subscribe(() => { this.cargar(); this.resetForm(); });
    } else {
      this.service.create(this.form).subscribe(() => { this.cargar(); this.resetForm(); });
    }
  }

  editar(c: Cliente) { this.form = { ...c }; this.editando = true; }

  eliminar(id: number) {
    if (confirm('¿Eliminar cliente?')) {
      this.service.delete(id).subscribe(() => this.cargar());
    }
  }

  resetForm() { this.form = { id: 0, nombre: '', email: '', telefono: '' }; this.editando = false; }
}