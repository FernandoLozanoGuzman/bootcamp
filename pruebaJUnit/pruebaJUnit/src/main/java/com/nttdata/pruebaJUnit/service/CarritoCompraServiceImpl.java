package com.nttdata.pruebaJUnit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nttdata.pruebaJUnit.model.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraServiceInterface {

	private List<Articulo> cesta=new ArrayList<Articulo>();
	private BaseDatosInterface bd;
	
	@Override
	public void limpiarCesta() {
		// TODO Auto-generated method stub
		cesta.clear();
	}

	@Override
	public void addArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		cesta.add(articulo);
	}

	@Override
	public Integer getNumArticulos() {
		// TODO Auto-generated method stub
		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		// TODO Auto-generated method stub
		return cesta;
	}

	@Override
	public Double totalPrice() {
		// TODO Auto-generated method stub
		Double total=0D;
		for(int i=0;i<cesta.size();i++){
			total+= cesta.get(i).getPrecio();
		}
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {
		// TODO Auto-generated method stub
		return precio-precio*porcentaje/100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		// TODO Auto-generated method stub
		bd.iniciar();
		Articulo articulo=bd.buscarArticulo(idArticulo);
		if(Optional.ofNullable(articulo).isPresent())
			return calculadorDescuento(articulo.getPrecio(), porcentaje);
		else
			System.out.println("No existe el articulo");
		return 0D;
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		bd.iniciar();
		Integer numArticulo=bd.insertarArticulo(articulo);
		return numArticulo;
	}

	
}
