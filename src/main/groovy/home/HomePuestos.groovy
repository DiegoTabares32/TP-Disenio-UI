package home

import java.util.concurrent.ConcurrentSkipListMap.Iter;

import scala.collection.parallel.ParIterableLike.Foreach;
import dominio.Banda
import dominio.Butaca
import dominio.Comprador
import dominio.Entrada
import dominio.Espectador
import dominio.Noche
import dominio.PuestoDeVenta
import dominio.Ubicacion

class HomePuestos {
	
	static def homeUbicaciones = HomeUbicaciones.INSTANCE
	static def homeButacas = HomeButacas.INSTANCE
	static def INSTANCE = getInstance()
	def puestos = [] as Set
	
	private HomePuestos(){
		super()
		this.init()
	}
	
	static def HomePuestos getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomePuestos()
		}
		return INSTANCE
	}
	
	def getIds(){
		def allIDs = puestos.collect{ it.id}
		return allIDs
		//return allIDs.unique(false) 
	}
	
	def init(){					
		
		def banda1 = new Banda("Radiohead", 4, 200)
		
		def puesto = new PuestoDeVenta("1")
		puesto.agregarEntradaVendida( new Entrada(
						new Comprador('Testa','Ferro'), new Espectador ('Jonas', 'Castillo', 23, 'Masculino'),
						homeUbicaciones.get(1), homeButacas.get(1), banda1,	new Noche( '13/09/2013', homeButacas.get(1), banda1)))
		this.agregarPuesto2(puesto)
		
		puesto = new PuestoDeVenta("1")
		puesto.agregarEntradaVendida( new Entrada(
						new Comprador('Diego','Roma'), new Espectador ('Melina', 'Miranda', 23, 'Masculino'),
						homeUbicaciones.get(2), homeButacas.get(2), banda1,	new Noche( '13/09/2013', homeButacas.get(2), banda1)))
		this.agregarPuesto2(puesto)
		
		puesto = new PuestoDeVenta("2")
		puesto.agregarEntradaVendida( new Entrada(
						new Comprador('Diego','Roma'), new Espectador ('Melina', 'Miranda', 23, 'Masculino'),
						homeUbicaciones.get(3), homeButacas.get(3), banda1,	new Noche( '13/09/2013', homeButacas.get(3), banda1)))
		this.agregarPuesto2(puesto)
	}
	
	def search(String id){
		def puestos =  this.puestos.findAll{ puesto -> puesto.id == id }
		def entradas = new ArrayList<>()
		if(puestos != null){	
			//agrego las entradas de a una porque si no se hace una lista de listas de entradas y rompe la ui		
			for (puesto in puestos) {
				for(entrada in puesto.entradasVendidas){
					entradas << entrada
				}
				
			}
			return entradas
		}
	}	
	
	def agregarPuesto2(unPuesto){
		try{
			PuestoDeVenta puesto = puestos.find{ puesto -> puesto.id == unPuesto.id}
			if(puesto != null){
				puesto.agregarEntradas(unPuesto.entradasVendidas)
			}else{
				puestos << unPuesto
			}
		}catch(NullPointerException e){
			puestos << unPuesto
		}
		
	}
}
