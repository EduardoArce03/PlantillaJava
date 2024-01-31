package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="facturas")
public class Factura {
	@Id
	@Column(name ="codigo")
	private int codigo;
	@Column(name="numero")
	private String numero;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_cliente")
	private Cliente cliente;
	@Column(name="total")
	private double total;
	@Column(name="fecha")
	private Date fechaEmision;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<DetalleFactura> detalle;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public List<DetalleFactura> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleFactura> detalle) {
		this.detalle = detalle;
	}
	public void addDetalle(DetalleFactura det) {
		if(detalle == null) {
			detalle = new ArrayList<DetalleFactura>();
		}
		detalle.add(det);
	}
	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", numero=" + numero + ", cliente=" + cliente + ", total=" + total
				+ ", fechaEmision=" + fechaEmision + ", detalle=" + detalle + "]";
	}
	
	


	
	
}
