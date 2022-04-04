package com.nttdata.pruebaJUnit.model;

public class Articulo {
	
	private String nombre;
	private Double precio;
	
	public Articulo(){}
	public Articulo(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	

}