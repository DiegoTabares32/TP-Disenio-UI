package aplicationModel



import java.util.List;

import dominio.Noche
import home.HomeNoches


@org.uqbar.commons.utils.Observable
class BuscadorDeBandas implements Serializable {   

	static def homeNoches = HomeNoches.getInstance()   
	def resultados = [] as Set
	String nombre
	def nombres = homeNoches.getNombresBandas()
	
	def search() {
		resultados = []
		
		resultados = homeNoches.searchBandasPorNombre(nombre)
	}
	
}
