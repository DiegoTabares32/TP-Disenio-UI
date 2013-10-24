package home

import dominio.Noche

class HomeNoches {
	
	static def homeButacas = HomeButacas.INSTANCE
	static def homeBandas = HomeBandas.INSTANCE
	static def INSTANCE = getInstance()
	def noches = [] as Set
	
	private HomeNoches(){
		super()
		this.init()
	}
	
	static def HomeNoches getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomeNoches()
		}
		return INSTANCE
	}
	
	def init(){
		noches << new Noche("23/05/2013", homeButacas.get(1), homeBandas.get(1))
		noches << new Noche("23/05/2013", homeButacas.get(2), homeBandas.get(1))
		noches << new Noche("4/10/2013", homeButacas.get(3), homeBandas.get(1))
	}
	
	def getFechas(){
		return this.noches.collect{ it.fecha }.unique(false)		
	}
		
	def search(def fecha){//butacas de esa fecha
		def nochesR = this.noches.findAll{ it -> it.fecha == fecha}
		def butacas = [] as Set
		if(nochesR != null){
			for(noche in nochesR){
				butacas.addAll(noche.butacas)
			}
			return butacas
		}
	}
}
