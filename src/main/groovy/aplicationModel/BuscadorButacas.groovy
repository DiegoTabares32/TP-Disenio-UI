package aplicationModel

import home.HomeButacas;
import home.HomeNoches;

@org.uqbar.commons.utils.Observable
class BuscadorButacas implements Serializable{

	static def homeButacas = HomeButacas.INSTANCE
	static def homeNoches = HomeNoches.INSTANCE
	def resultados = [] as Set // son las butacas
	def fecha
	def fechas = homeNoches.getFechas()
	def butacaSeleccionada
	def contrasenia = null
	def butacasAComprar = [] as Set

	def BuscadorButacas(){
		super()
	}
	
	def search(){
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = []
		// FIN WORKAROUND
		resultados = homeNoches.search(fecha, contrasenia)//con esta fecha busca la noche cuya fecha coincida y devuelve las butacas
	}

	def remove(){
		homeNoches.remove(fecha, butacaSeleccionada)
		butacasAComprar << butacaSeleccionada
	}

	def add(){
		homeNoches.add()
	}

	def finalizarCompra(){
		homeNoches.finalizarCompra()
		butacasAComprar = []
	}

	def clear(){
		this.fecha = null
		this.contrasenia = null
		this.search()
	}
}
