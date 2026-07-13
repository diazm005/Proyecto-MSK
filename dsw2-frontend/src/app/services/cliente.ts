import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Cliente {
  id: number;
  nombre: string;
  email: string;
  telefono: string;
}

@Injectable({ providedIn: 'root' })
export class ClienteService {
  private url = 'http://localhost:8080/api/clientes';

  constructor(private http: HttpClient) {}

  private getHeaders() {
  const token = localStorage.getItem('token');
  return { headers: new HttpHeaders({ 'Authorization': `Bearer ${token}` }) };
}

  getAll(): Observable<Cliente[]> { return this.http.get<Cliente[]>(this.url, this.getHeaders()); }
  getById(id: number): Observable<Cliente> { return this.http.get<Cliente>(`${this.url}/${id}`, this.getHeaders()); }
  create(c: Cliente): Observable<Cliente> { return this.http.post<Cliente>(this.url, c, this.getHeaders()); }
  update(id: number, c: Cliente): Observable<Cliente> { return this.http.put<Cliente>(`${this.url}/${id}`, c, this.getHeaders()); }
  delete(id: number): Observable<void> { return this.http.delete<void>(`${this.url}/${id}`, this.getHeaders()); }
}