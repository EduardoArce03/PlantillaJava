package business;

import java.util.Date;
import java.util.List;

import dao.ClienteDAO;
import dao.CuentaDAO;
import dao.FacturaDAO;
import dao.TransaccionDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import model.Cliente;
import model.Cuenta;
import model.DetalleFactura;
import model.Factura;
@Singleton
@Startup
public class GestionDatos {
	@Inject
	private ClienteDAO daoCliente;
	@Inject
	private FacturaDAO facturaDAO;
	@Inject
	private CuentaDAO daoCuenta;
	@Inject
	private TransaccionDAO transaccionDAO;
	@Inject
	private GestionCuentas gestionCuentas;
	@PostConstruct
	public void init() {
		/*System.out.println("Iniciando.........");
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0150517241");
		cliente.setDireccion("Arenal");
		cliente.setNombre("Edu");
		
		clienteDAO.insert(cliente);
		
		cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setDni("0150517242");
		cliente.setDireccion("Chaulla");
		cliente.setNombre("Erick");
		
		clienteDAO.insert(cliente);
		
		Factura factura = new Factura();
		factura.setCodigo(20);
		factura.setCliente(cliente);
		factura.setNumero("001-001-00000001");
		factura.setFechaEmision(new Date());
		factura.setTotal(1000.52);
		
		DetalleFactura det = new DetalleFactura();
		det.setCodigo(1);
		det.setNombre("TV");
		det.setCantidad(2);
		det.setPrecio(150.5);
		
		factura.addDetalle(det);
		
		det = new DetalleFactura();
		det.setCodigo(10);
		det.setNombre("Cocina");
		det.setCantidad(1);
		det.setPrecio(150.5);
		
		factura.addDetalle(det);
		
		
		facturaDAO.insert(factura);
		
		System.out.println("\n------------- Facturas2");
		List<Factura> list2 = facturaDAO.getAll();
		for(Factura fac : list2) {
			System.out.println(fac);
		}*/
		
		System.out.println("iniciando");
		
		Cliente cliente1 = new Cliente();
		cliente1.setCodigo(1);
		cliente1.setDni("1150704672");
		cliente1.setDireccion("Ricaurte");
		cliente1.setNombre("Pablo Bravo");
		
		daoCliente.insert(cliente1);
		// Crear y guardar cuentas
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNumeroCuenta(101);
        cuenta1.setSaldo(1000.0);
        cuenta1.setCliente(cliente1);
        daoCuenta.insert(cuenta1);
		
        Cliente cliente2 = new Cliente();
		cliente2 = new Cliente();
		cliente2.setCodigo(2);
		cliente2.setDni("098987332");
		cliente2.setDireccion("Monay");
		cliente2.setNombre("Eduardo Arce");
		
		daoCliente.insert(cliente2);
		

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNumeroCuenta(102);
        cuenta2.setSaldo(500.0);
        cuenta2.setCliente(cliente2);
        daoCuenta.insert(cuenta2);
		
		System.out.println("\n------------- Clientes---------------");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}
		
		System.out.println("\n------------- Clientes---------------");
		List<Cuenta> list2 = daoCuenta.getAll();
		for (Cuenta cli: list2) {
			System.out.println(cli.getCliente().getNombre() + "\t" + cli.getSaldo());
		}
		
		 try {
	            gestionCuentas.realizarTransferencia(101, 102, 200.0);
	            System.out.println("Transferencia realizada con éxito");
	        } catch (Exception e) {
	            System.out.println("Error al realizar la transferencia: " + e.getMessage());
	        }

	        // Mostrar el saldo actual de las cuentas
	        System.out.println("\n------------- Saldo de Cuentas Final ---------------");
	        System.out.println("Cuenta 101: " + daoCuenta.read(101).getSaldo());
	        System.out.println("Cuenta 102: " + daoCuenta.read(102).getSaldo());
	        
	        
	        try {
	            gestionCuentas.realizarTransferencia(101, 102, 200.0);
	            System.out.println("Transferencia realizada con éxito");
	        } catch (Exception e) {
	            System.out.println("Error al realizar la transferencia: " + e.getMessage());
	        }

	        // Mostrar el saldo actual de las cuentas
	        System.out.println("\n------------- Saldo de Cuentas Final ---------------");
	        System.out.println("Cuenta 101: " + daoCuenta.read(101).getSaldo());
	        System.out.println("Cuenta 102: " + daoCuenta.read(102).getSaldo());  
	        
	        
	    }
	}

