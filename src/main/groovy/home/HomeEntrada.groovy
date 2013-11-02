package home

import com.sun.org.apache.bcel.internal.generic.RETURN;

import dominio.Banda
import dominio.Butaca
import dominio.Comprador
import dominio.Entrada
import dominio.Espectador
import dominio.Noche
import dominio.Ubicacion

class HomeEntrada {
	
	static def homeUbicaciones = HomeUbicaciones.INSTANCE
	static def homeButacas = HomeButacas.INSTANCE
	static def homeNoches = HomeNoches.INSTANCE
	static def homeEspectadores = HomeEspectadores.INSTANCE
	static def homeBandas = HomeBandas.INSTANCE
	static def homeClientes = HomeClientes.INSTANCE
	def entradas = [] as Set
	static def INSTANCE = new HomeEntrada()
	
	private HomeEntrada(){
		super()		
	}
	
	static def HomeEntrada getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomeEntrada()
		}
		return INSTANCE
	}
	
	def agregarEntrada(entrada){
		entradas << entrada
	}
	
	def buscar(def fecha){
//		entradas.findAll {
//			entrada -> entrada.getFecha().equals(fecha)
//		}
		return this.entradas
	}
	
	def get(id){
		return this.entradas.find{it.id == id }
	}
}
