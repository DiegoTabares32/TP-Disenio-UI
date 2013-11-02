package home

import dominio.Banda

class HomeBandas {

	static def INSTANCE = getInstance()
	def bandas = [] as Set
	
	private HomeBandas(){
		super()
		this.init()
	}
	
	static def HomeBandas getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomeBandas()
		}
		return INSTANCE
	}
	
	def init(){
		bandas << new Banda("metallica", 1, 30)// id 1
		bandas << new Banda("Queen", 2, 50) //id 2
	}
	
	def get(id){
		return this.bandas.find{ it.id == id }
	}
}
