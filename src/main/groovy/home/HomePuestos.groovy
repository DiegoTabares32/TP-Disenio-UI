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
		return puestos.collect{ it.id}
	}
	
	def init(){
		def ubicacion = new Ubicacion("azul", 5)
		def butacas = new Butaca(23, ubicacion, null)
		def banda1 = new Banda("Radiohead", 4, 200)
		
		def puesto = new PuestoDeVenta("1")
		puesto.agregarEntradaVendida( new Entrada(
						new Comprador('Testa','Ferro'), new Espectador ('Jonas', 'Castillo', 23, 'Masculino'),
						ubicacion, butacas, banda1,	new Noche( '13/09/2013', butacas, banda1)))
		puestos << puesto
		puesto = new PuestoDeVenta("1")
		puesto.agregarEntradaVendida( new Entrada(
						new Comprador('Diego','Roma'), new Espectador ('Melina', 'Miranda', 23, 'Masculino'),
						ubicacion, butacas, banda1,	new Noche( '13/09/2013', butacas, banda1)))
		puestos << puesto
	}
	
	def search(String id){
		def puestos =  this.puestos.findAll{ puesto -> puesto.id == id }
		def entradas = new ArrayList<>()
		if(puestos != null){			
			for (puesto in puestos) {
				for(entrada in puesto.entradasVendidas){
					entradas << entrada
				}
				
			}
			return entradas
		}
		
	}
}
