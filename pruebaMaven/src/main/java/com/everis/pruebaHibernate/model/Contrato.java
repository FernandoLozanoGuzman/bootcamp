package com.everis.pruebaHibernate.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Contrato {

	@ManyToOne	
	private Long id_contrato;
	private Date fechaVigencia, fecahCaducidad;
	private double precio;
	private Cliente cliente;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id_contrato;
	}
	public void setId(Long id_contrato) {
		this.id_contrato = id_contrato;
	}
	

	@Column(name="FECHA_VIGENCIA_CONTRATO")
	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	
	@Column(name="FECHA_CADUCIDA_CONTRATO")
	public Date getFecahCaducidad() {
		return fecahCaducidad;
	}
	public void setFecahCaducidad(Date fecahCaducidad) {
		this.fecahCaducidad = fecahCaducidad;
	}

	@Column(name="PRECIO_CONTRATO")
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Column(name="CLIENTE_CONTRATO")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
