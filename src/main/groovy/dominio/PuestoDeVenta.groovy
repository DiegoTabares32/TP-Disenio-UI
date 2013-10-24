package dominio

import org.uqbar.commons.utils.Observable;

@Observable
class PuestoDeVenta {
	
	def id
	def entradasVendidas = [] as Set
	
	def PuestoDeVenta(def id){
		this.id = id	
	}
	
	def agregarEntradaVendida(def entrada){
		this.entradasVendidas << entrada
	}
	
	def agregarEntradas(def entradas){
		this.entradasVendidas.addAll(entradas)
	}
}

