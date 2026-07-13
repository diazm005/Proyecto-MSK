import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Pedido {
  id: number;
  fecha: string;
  estado: string;
  total: number;
  cliente: { id: number; nombre: string; email: string; telefono: string };
}

@Injectable({ providedIn: 'root' })
export class PedidoService {
  private url = 'http://localhost:8080/api/pedidos';

  constructor(private http: HttpClient) {}

  private getHeaders() {
  const token = localStorage.getItem('token');
  return { headers: new HttpHeaders({ 'Authorization': `Bearer ${token}` }) };
}

  getAll(): Observable<Pedido[]> { return this.http.get<Pedido[]>(this.url, this.getHeaders()); }
  getById(id: number): Observable<Pedido> { return this.http.get<Pedido>(`${this.url}/${id}`, this.getHeaders()); }
  create(p: Pedido): Observable<Pedido> { return this.http.post<Pedido>(this.url, p, this.getHeaders()); }
  delete(id: number): Observable<void> { return this.http.delete<void>(`${this.url}/${id}`, this.getHeaders()); }
}