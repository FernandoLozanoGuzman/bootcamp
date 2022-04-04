package com.nttdata.pruebaJUnit.service;

import java.util.List;

import com.nttdata.pruebaJUnit.model.Articulo;

public interface CarritoCompraServiceInterface {

	public void limpiarCesta();
	public void addArticulo(Articulo articulo);
	public Integer getNumArticulos();
	public List<Articulo> getArticulos();
	public Double totalPrice();
	public Double calculadorDescuento(Double precio, Double porcentaje);
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);
	public Integer insertarArticulo(Articulo articulo); 
}
