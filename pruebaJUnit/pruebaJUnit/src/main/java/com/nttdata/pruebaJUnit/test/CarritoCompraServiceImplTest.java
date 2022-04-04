package com.nttdata.pruebaJUnit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nttdata.pruebaJUnit.model.Articulo;
import com.nttdata.pruebaJUnit.service.BaseDatosInterface;
import com.nttdata.pruebaJUnit.service.CarritoCompraServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImplTest {

	@InjectMocks
	private CarritoCompraServiceImpl carritoService=new CarritoCompraServiceImpl();

	@Mock
	private BaseDatosInterface bd;
	
	@Test
	public void testLimpiarCesta() {
		carritoService.addArticulo(new Articulo("Camiseta",15.56));
		assertFalse(carritoService.getArticulos().isEmpty());
		carritoService.limpiarCesta();
		assertTrue(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testAddArticulo() {
		carritoService.addArticulo(new Articulo("Camiseta",15.56));
		int numArticulos=carritoService.getNumArticulos();
		assertEquals(1,numArticulos);
		assertTrue(carritoService.getArticulos().get(0).getNombre().equals("Camiseta"));
	}

	@Test
	public void testGetNumArticulos() {
		carritoService.addArticulo(new Articulo("Camiseta",15.56));
		carritoService.addArticulo(new Articulo("Pantalon",19.99));
		int numArticulos=carritoService.getNumArticulos();
		assertEquals(2,numArticulos);
		assertTrue(carritoService.getArticulos().get(1).getPrecio()==19.99);
	}

	@Test
	public void testGetArticulos() {
		carritoService.addArticulo(new Articulo("Camiseta",15.56));
		carritoService.addArticulo(new Articulo("Pantalon",19.99));
		int numArticulos=carritoService.getNumArticulos();
		assertTrue(carritoService.getArticulos().size()==numArticulos);
		assertFalse(carritoService.getArticulos().get(1).getNombre().equals("Camiseta"));
	}

	@Test
	public void testTotalPrice() {
		carritoService.addArticulo(new Articulo("Camiseta",12.00));
		carritoService.addArticulo(new Articulo("Pantalon",20.00));
		List<Articulo> articulos=carritoService.getArticulos();
		double total=0;
		for(Articulo articulo:articulos){
			total+=articulo.getPrecio();
		}
		assertTrue(32==total);
		assertEquals(Double.valueOf(32), Double.valueOf(total));
	}

	@Test
	public void testCalculadorDescuento() {
		carritoService.addArticulo(new Articulo("Pantalon",20.00));
		double precioDescuento=carritoService.calculadorDescuento(carritoService.getArticulos().get(0).getPrecio(), 50.00);
		assertFalse(32==precioDescuento);
		assertEquals(Double.valueOf(10),Double.valueOf(precioDescuento));
	}

	@Test
	public void testAplicarDescuento(){		
		Articulo articulo=new Articulo("Camiseta",20.00);
		when(bd.buscarArticulo(any(Integer.class))).thenReturn(articulo);
		Double res=carritoService.aplicarDescuento(1, 50D);
		assertEquals(Double.valueOf(10D), res);
	}
	
	@Test
	public void testInsertarArticulo(){
		Articulo articulo=new Articulo("Camiseta",20.00);
		carritoService.addArticulo(articulo);
		//comprobaciones con el service
		assertTrue(carritoService.getArticulos().get(0).getNombre().equals("Camiseta"));
		assertEquals(carritoService.getArticulos().get(0).getPrecio(),Double.valueOf(20) );
		
		//comporbaciones base de datos
		when(bd.insertarArticulo(articulo)).thenReturn(8);
		Integer idArt=carritoService.insertarArticulo(articulo);
		System.out.println("ID del articulo: "+idArt);
		assertEquals(Double.valueOf(8), Double.valueOf(idArt));
		verify(bd,times(1)).insertarArticulo(articulo);
	}

}
