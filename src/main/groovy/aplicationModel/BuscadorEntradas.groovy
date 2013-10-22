package aplicationModel

import home.HomeEntrada

@org.uqbar.commons.utils.Observable
class BuscadorEntradas implements Serializable {
	
	def fecha
	def resultados = [] as Set
	def entradaSeleccionada
	def homeEntrada = HomeEntrada.INSTANCE
	
	def buscar() {
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = []
		// FIN WORKAROUND
		resultados = homeEntrada.buscar(fecha)
	}
	
	def clear() {
		fecha = null		
	}

	def eliminarEntradaSeleccionada() {
		homeEntrada.delete(entradaSeleccionada)
		this.buscar()
		entradaSeleccionada = null
	}

	def getHomeEntradas() {
		ApplicationContext.instance.getSingleton(Entrada.class)
	}
}
