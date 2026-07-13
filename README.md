# Proyecto MSK - Sistema de Gestión de Pedidos

Sistema web desarrollado para **MSK Importaciones SAC**, empresa dedicada a la importación y distribución de pernería, tornillería y ferretería en el Perú.

## Descripción

El sistema permite gestionar productos, clientes y pedidos de forma digital, reemplazando procesos manuales por una solución moderna con autenticación segura.

## Tecnologías utilizadas

### Backend — Spring Boot 3.2.5
- **REST API** — CRUD de Productos, Clientes y Pedidos
- **SOAP** — Servicio web para consulta de productos con contrato WSDL
- **Threads** — Procesamiento asíncrono de pedidos en segundo plano
- **Sockets** — Servidor TCP en puerto 12345
- **Feign Client** — Consumo de API externa (FakeStore API)
- **Spring Security + JWT** — Autenticación y protección de endpoints
- **H2 Database** — Base de datos en memoria

### Frontend — Angular 17
- Componentes standalone
- Interceptor HTTP para JWT automático
- Auth Guard para protección de rutas
- Bootstrap + CSS personalizado

## Estructura del proyecto
Proyecto-MSK/
|-- dsw2/           - Backend Spring Boot
|-- dsw2-frontend/  - Frontend Angular

## Cómo ejecutar

### Backend
1. Abrir "dsw2" en Eclipse como proyecto Maven
2. Maven → Update Project
3. Run as Spring Boot App
4. Disponible en "http://localhost:8080"

### Frontend
```bash
cd dsw2-frontend
npm install
npx ng serve
```
Disponible en "http://localhost:4200"

## Credenciales de prueba
- **Usuario:** admin
- **Contraseña:** admin321

## Endpoints principales
| Tecnología | URL |
|---|---|
| REST Productos | `http://localhost:8080/api/productos` |
| REST Clientes | `http://localhost:8080/api/clientes` |
| REST Pedidos | `http://localhost:8080/api/pedidos` |
| SOAP WSDL | `http://localhost:8080/ws/productos.wsdl` |
| Feign Client | `http://localhost:8080/api/external/productos` |
| H2 Console | `http://localhost:8080/h2-console` |

## Autor
**Martín Diaz** 
