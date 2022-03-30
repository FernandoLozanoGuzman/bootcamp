package com.everis.pruebaHibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_contrato")

	private Long id_cliente;
	private String nombre, primerApellido, segundoApellido, DNI;
	private Contrato contrato;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id_cliente;
	}
	public void setId(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	@Column(name="NOMBRE_CLIENTE")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="PRIMER_APELLIDO_CLIENTE")
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	@Column(name="SEGUNDO_APELLIDO_CLIENTE")
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	@Column(name="DNI_CLIENTE", unique=true, nullable=false, length=9)
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	@Column(name="CONTRATO_CLIENTE")
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
}
