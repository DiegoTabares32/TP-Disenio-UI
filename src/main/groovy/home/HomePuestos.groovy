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
	static def homeClientes = HomeClientes.INSTANCE
	static def homeNoches = HomeNoches.INSTANCE
	static def homeBandas = HomeBandas.INSTANCE
	static def homeEspectadores = HomeEspectadores.INSTANCE
	static def homeEntrada = HomeEntrada.INSTANCE
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
		puesto.agregarEntradaVendida(homeEntrada.get(1))
		this.agregarPuesto2(puesto)

		puesto = new PuestoDeVenta("1")
		puesto.agregarEntradaVendida(homeEntrada.get(2))
		this.agregarPuesto2(puesto)

		puesto = new PuestoDeVenta("2")
		puesto.agregarEntradaVendida(homeEntrada.get(3))
		this.agregarPuesto2(puesto)
	}

	def search(String id){
		def puestos =  this.puestos.findAll{ puesto -> puesto.id == id }
		def entradas = []
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
