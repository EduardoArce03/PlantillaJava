package business;

import dao.CuentaDAO;
import dao.TransaccionDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import model.Cuenta;
import model.Transaccion;

@Stateless
public class GestionCuentas {
	@Inject
	private CuentaDAO cuentaDAO;
	@Inject
	private TransaccionDAO transaccionDAO;
	
	public void realizarTransferencia(int cuentaOrigenID, int cuentaDestinoID, double monto) throws Exception {
		Cuenta cuentaOrigen = cuentaDAO.read(cuentaOrigenID);
		Cuenta cuentaDestino = cuentaDAO.read(cuentaDestinoID);
		if(cuentaOrigen == null || cuentaDestino == null) {
			throw new Exception("Una de las cuentas no existe bro MmM");
		}
		if (cuentaOrigen.getSaldo() < monto) {
			throw new Exception("El saldo es insuficiente");
		}
		cuentaOrigen.retirar(monto);
		cuentaDestino.depositar(monto);
		
		cuentaDAO.update(cuentaDestino);
		cuentaDAO.update(cuentaOrigen);
		
		Transaccion transaccion = new Transaccion();
		transaccion.setCuentaDestino(cuentaDestino);
		transaccion.setCuentaOrigen(cuentaOrigen);
		transaccion.setMonto(monto);
		transaccionDAO.insert(transaccion);
	}
}
