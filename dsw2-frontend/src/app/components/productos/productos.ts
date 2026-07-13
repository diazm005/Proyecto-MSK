import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Producto, ProductoService } from '../../services/producto';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './productos.html'
})
export class ProductosComponent implements OnInit {
  productos: Producto[] = [];
  form: Producto = { id: 0, nombre: '', descripcion: '', precio: 0, stock: 0 };
  editando = false;

  constructor(private service: ProductoService) {}

  ngOnInit() { this.cargar(); }

  cargar() { this.service.getAll().subscribe(data => this.productos = data); }

  guardar() {
    if (this.editando) {
      this.service.update(this.form.id, this.form).subscribe(() => { this.cargar(); this.resetForm(); });
    } else {
      this.service.create(this.form).subscribe(() => { this.cargar(); this.resetForm(); });
    }
  }

  editar(p: Producto) { this.form = { ...p }; this.editando = true; }

  eliminar(id: number) {
    if (confirm('¿Eliminar producto?')) {
      this.service.delete(id).subscribe(() => this.cargar());
    }
  }

  resetForm() { this.form = { id: 0, nombre: '', descripcion: '', precio: 0, stock: 0 }; this.editando = false; }
}