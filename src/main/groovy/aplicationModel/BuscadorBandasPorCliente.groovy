package aplicationModel

import java.io.Serializable;
import home.HomeBandasPorCliente

@org.uqbar.commons.utils.Observable
class BuscadorBandasPorCliente implements Serializable{
	
	static def homeBandasPorCliente = HomeBandasPorCliente.INSTANCE
	def resultados = [] as Set
	def nombre
	def apellido
	/*def fechaCompra
	def fechaFin*/
	
	def search(){
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = []
		// FIN WORKAROUND
		resultados = homeBandasPorCliente.search(nombre, apellido)
	}
	
	def clear(){
		this.nombre = null
		this.apellido = null
	    this.search()
	}

}
