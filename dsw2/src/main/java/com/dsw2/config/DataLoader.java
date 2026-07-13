package com.dsw2.config;

import com.dsw2.model.Cliente;
import com.dsw2.model.Pedido;
import com.dsw2.model.Producto;
import com.dsw2.model.Usuario;
import com.dsw2.repository.ClienteRepository;
import com.dsw2.repository.PedidoRepository;
import com.dsw2.repository.ProductoRepository;
import com.dsw2.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository productoRepo;
    private final ClienteRepository clienteRepo;
    private final PedidoRepository pedidoRepo;
    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(ProductoRepository productoRepo,
                      ClienteRepository clienteRepo,
                      PedidoRepository pedidoRepo,
                      UsuarioRepository usuarioRepo,
                      PasswordEncoder passwordEncoder) {
        this.productoRepo = productoRepo;
        this.clienteRepo = clienteRepo;
        this.pedidoRepo = pedidoRepo;
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        //PRODUCTOSS 
    	//PERNERIA
    	Producto p1 = productoRepo.save(new Producto(0, "Pernos Hexagonales", "Perno hexagonal de alta resistencia G8 1/2x3 ZB", 4.50, 500));
    	Producto p2 = productoRepo.save(new Producto(0, "Varillas Roscadas", "Varilla roscada corriente 1 metro 3/8", 12.00, 150));

    	//LINEA INOXIDABLE
    	Producto p3 = productoRepo.save(new Producto(0, "Pernos Inoxidables", "Perno hexagonal acero inoxidable 316 1/4x1", 6.80, 300));
    	Producto p4 = productoRepo.save(new Producto(0, "Arandelas Inoxidables", "Arandela plana acero inoxidable 304 5/16", 1.20, 1000));

    	//TORNILLERIA
    	Producto p5 = productoRepo.save(new Producto(0, "Tornillos Chipboard", "Tornillo madera chipboard zincado 4x50mm x cien unidades", 18.50, 80));
    	Producto p6 = productoRepo.save(new Producto(0, "Tornillos para Drywall", "Tornillo drywall punta aguja de 6x1 x cien unidades", 14.00, 120));

    	//ABRAZADERAS Y COLGADORES
    	Producto p7 = productoRepo.save(new Producto(0, "Abrazaderas p/manguera", "Abrazadera metálica sin fin para manguera de 1 pulgada", 3.20, 400));
    	Producto p8 = productoRepo.save(new Producto(0, "Colgadores Tipo Clevis", "Colgador tipo clevis cincado para tubería de 2 pulgadas", 8.50, 90));

    	//MANIOBRAS E IZAJE
    	Producto p9 = productoRepo.save(new Producto(0, "Cables de Acero", "Cable de acero estrobado de 3/8 por metro", 15.50, 200));
    	Producto p10 = productoRepo.save(new Producto(0, "Templadores", "Templador ojo y gancho forjado de 1/2 pulgada", 24.90, 45));

    	//PINTURAS EN SPRAY
    	Producto p11 = productoRepo.save(new Producto(0, "Pintura Spray Negro Mate", "Pintura aerosol acabado mate secado rapido 400ml", 14.50, 60));
    	Producto p12 = productoRepo.save(new Producto(0, "Pintura Spray Rojo Fuego", "Pintura aerosol color rojo fuego brillante 400ml", 14.50, 55));

    	//BROCAS, DISCOS Y ACCESORIOS
    	Producto p13 = productoRepo.save(new Producto(0, "Brocas para Concreto", "Broca para concreto punta de carburo de tungsteno 3/8", 18.00, 75));
    	Producto p14 = productoRepo.save(new Producto(0, "Discos de Corte", "Disco de corte para metal y acero inoxidable 4 1/2 extra fino", 5.50, 600));

    	//VALVULAS Y CONEXIONES
    	Producto p15 = productoRepo.save(new Producto(0, "Válvulas Esféricas", "Válvula esférica de bronce para agua de 1/2 pulgada pesado", 28.00, 40));
    	Producto p16 = productoRepo.save(new Producto(0, "Grifos - Caños de Jardín", "Caño para jardín de bronce cromado de 1/2 pulgada con salida manguera", 22.50, 35));

    	//RACKS Y ESTANTERIAS
    	Producto p17 = productoRepo.save(new Producto(0, "Racks Naranja - 800 KG", "Rack industrial de almacenamiento carga pesada color naranja", 850.00, 10));
    	Producto p18 = productoRepo.save(new Producto(0, "Racks Amarillo - 300 KG", "Rack de estantería mediana carga media color amarillo", 450.00, 15));

        //CLIENTES
        Cliente c1 = clienteRepo.save(new Cliente(0, "Martin Diaz",   "martin@email.com",  "999111222"));
        Cliente c2 = clienteRepo.save(new Cliente(0, "Alonso Chamba", "alonso@email.com",  "999333444"));
        Cliente c3 = clienteRepo.save(new Cliente(0, "Carlos Lopez",  "carlos@email.com",  "999555666"));

        //PEDIDOS
        pedidoRepo.save(new Pedido(0, LocalDateTime.now(), "PENDIENTE", 2500.0, c1));
        pedidoRepo.save(new Pedido(0, LocalDateTime.now(), "PROCESADO", 3000.0, c2));
        pedidoRepo.save(new Pedido(0, LocalDateTime.now(), "PENDIENTE", 5080.0, c3));

        //USUARIO
        Usuario admin = new Usuario(0, "admin", passwordEncoder.encode("admin321"), "ADMIN");
        usuarioRepo.save(admin);
    }
}