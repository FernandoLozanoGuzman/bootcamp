package com.nttdata.pruebaJUnit.service;

import java.util.HashMap;
import java.util.Map;

import com.nttdata.pruebaJUnit.model.Articulo;

public class BaseDatosImpl implements BaseDatosInterface {

	private Map<Integer,Articulo> map; 
	
	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		map=new HashMap<>();
		map.put(1, new Articulo("Camiseta",15.00));
		map.put(2, new Articulo("Pantalon",10.00));
		map.put(3, new Articulo("Jersey",25.00));
		map.put(4, new Articulo("Chaqueta",49.99));
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		map.put(map.size()+1, articulo);
		return map.size();
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {
		// TODO Auto-generated method stub
		return map.get(identificador);
	}

}
