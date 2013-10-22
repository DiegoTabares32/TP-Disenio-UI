package aplicationModel

import home.HomePuestos;

@org.uqbar.commons.utils.Observable
class BuscadorPuestoVentas implements Serializable {
	
	static def homePuestos = HomePuestos.INSTANCE
	def resultados = [] as Set
	def id 
	def ids = homePuestos.getIds()
	
	
	def search(){
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = []
		// FIN WORKAROUND
		resultados = homePuestos.search(id)
	}
	
	def clear(){
		this.id = null
		this.search()
	}
}