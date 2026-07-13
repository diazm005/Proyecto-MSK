import { Routes } from '@angular/router';
import { ProductosComponent } from './components/productos/productos';
import { ClientesComponent } from './components/clientes/clientes';
import { PedidosComponent } from './components/pedidos/pedidos';
import { LoginComponent } from './components/login/login';
import { authGuard } from './guards/auth-guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'productos', component: ProductosComponent, canActivate: [authGuard] },
  { path: 'clientes', component: ClientesComponent, canActivate: [authGuard] },
  { path: 'pedidos', component: PedidosComponent, canActivate: [authGuard] }
];