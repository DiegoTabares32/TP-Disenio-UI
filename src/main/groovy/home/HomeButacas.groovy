package home

import dominio.Butaca

class HomeButacas {

	static def homeUbicaciones = HomeUbicaciones.INSTANCE
	static def INSTANCE = getInstance()
	def butacas = [] as Set
	def butacaSeleccionada
	
	private HomeButacas(){
		super()
		this.init()
	}
	
	static def HomeButacas getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomeButacas()
		}
		return INSTANCE
	}
	
	def init(){
		butacas << new Butaca(1, homeUbicaciones.get(1), null)// id 1
		butacas << new Butaca(4, homeUbicaciones.get(2), null)// id 2
		butacas << new Butaca(6, homeUbicaciones.get(3), null)// id 3
		butacas << new Butaca(7, homeUbicaciones.get(4), null)// id 4
		butacas << new Butaca(9, homeUbicaciones.get(5), null)// id 5
		
	}
	
	def get(def id){
		return this.butacas.find{butaca -> butaca.id == id}
	}

	
}
