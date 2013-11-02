package home

import dominio.Noche

class HomeNoches {

	static def homeButacas = HomeButacas.INSTANCE
	static def homeBandas = HomeBandas.INSTANCE
	static def INSTANCE = getInstance()
	def noches = [] as Set
	def butacasAComprar = [] as Set

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
		noches << new Noche("23/05/2013", homeButacas.get(1), homeBandas.get(1)) //id 1
		noches << new Noche("23/05/2013", homeButacas.get(3), homeBandas.get(1)) //id 1
		noches << new Noche("23/05/2013", homeButacas.get(2), homeBandas.get(1)) //id 2
		noches << new Noche("4/10/2013", homeButacas.get(3), homeBandas.get(1)) //id 3
		noches << new Noche("23/05/2013", homeButacas.get(6), homeBandas.get(1)) //id 4
		noches << new Noche("4/10/2013", homeButacas.get(7), homeBandas.get(1)) //id 5
		noches << new Noche("13/09/2013", homeButacas.get(3), homeBandas.get(1)) //id 6 vendida
		noches << new Noche("13/09/2013", homeButacas.get(2), homeBandas.get(1)) // id 7 vendida
		noches << new Noche( '13/09/2013', homeButacas.get(1), homeBandas.get(1))//id 8 vendida
	}

	def getFechas(){
		return this.noches.collect{ it.fecha }.unique(false)    
	}

	def search(fecha, contrasenia){
		//butacas de esa fecha
		def nochesR = this.noches.findAll{ it -> it.fecha == fecha}
		def butacas = [] as Set
		if(nochesR != null){
			for(noche in nochesR){
				butacas.addAll(noche.butacas)
			}
			return butacas.findAll{it -> it.contrasenia == contrasenia}
		}
	}

	def remove(fecha, butacaARemover){
		def nochesR = []
		nochesR = noches.findAll{it.fecha == fecha}
		def nocheRR = nochesR.find{it.butacas.contains(butacaARemover)}
		noches.remove(nocheRR)
		butacasAComprar << nocheRR
	}
	
	def add(){
		noches.addAll(butacasAComprar)
	}
	
	def finalizarCompra(){
		butacasAComprar = []
	}
	
	def get(def id){
		return this.noches.find{noche -> noche.id == id}
	}
	
	//
	def getNombresBandas(){
		def allNombresBandas = []
				for (noche in noches){
					noche.bandas.each{
								if (!allNombresBandas.contains(it.nombreBanda)) {
									allNombresBandas << it.nombreBanda }
								}
				}
		return allNombresBandas
	}
	
	def searchBandasPorNombre(String nombre){
			def bandaEncontrada = []
			def resultados = new ArrayList<>()
			
			for (noche in noches) {
				bandaEncontrada = noche.bandas.find { banda -> banda.nombreBanda == nombre}
				if(bandaEncontrada != null){
						resultados << noche
				}
			}
			return resultados
	}

}