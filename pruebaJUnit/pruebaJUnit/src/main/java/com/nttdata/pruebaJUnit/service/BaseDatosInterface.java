package com.nttdata.pruebaJUnit.service;

import com.nttdata.pruebaJUnit.model.Articulo;

public interface BaseDatosInterface {

	public void iniciar();
	public Integer insertarArticulo(Articulo articulo);
	public Articulo buscarArticulo(Integer identificador);
}
