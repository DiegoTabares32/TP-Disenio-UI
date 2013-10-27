package aplicationModel

import home.HomeClientes

@org.uqbar.commons.utils.Observable
class BuscadorClientes implements Serializable{
	
	static def homeClientes = HomeClientes.INSTANCE
	def resultados = [] as Set
	def nombre
	def apellido
	
	def search(){
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = []
		// FIN WORKAROUND
		resultados = homeClientes.search(nombre, apellido)
	}
	
	def clear(){
		this.nombre = null
		this.apellido = null
		this.search()
	}

}
