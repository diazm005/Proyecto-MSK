import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Producto {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number;
  stock: number;
}

@Injectable({ providedIn: 'root' })
export class ProductoService {
  private url = 'http://localhost:8080/api/productos';

  constructor(private http: HttpClient) {}

  private getHeaders() {
    const token = localStorage.getItem('token');
    return { headers: new HttpHeaders({ 'Authorization': `Bearer ${token}` }) };
  }

  getAll(): Observable<Producto[]> { return this.http.get<Producto[]>(this.url, this.getHeaders()); }
  getById(id: number): Observable<Producto> { return this.http.get<Producto>(`${this.url}/${id}`, this.getHeaders()); }
  create(p: Producto): Observable<Producto> { return this.http.post<Producto>(this.url, p, this.getHeaders()); }
  update(id: number, p: Producto): Observable<Producto> { return this.http.put<Producto>(`${this.url}/${id}`, p, this.getHeaders()); }
  delete(id: number): Observable<void> { return this.http.delete<void>(`${this.url}/${id}`, this.getHeaders()); }
}