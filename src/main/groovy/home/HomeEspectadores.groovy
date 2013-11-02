package home

import dominio.Espectador

class HomeEspectadores {

	static def INSTANCE = getInstance()
	def espectadores = [] as Set
	
	private HomeEspectadores(){
		super()
		this.init()
	}
	
	static def HomeEspectadores getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomeEspectadores()
		}
		return INSTANCE
	}
	
	def init(){
		espectadores << new Espectador('Jonas', 'Castillo', 23, 'Masculino') //id 1
		espectadores << new Espectador('Melina', 'Miranda', 23, 'Femenino') //id 2
		espectadores << new Espectador("Juan", "Perez", 25, 'Masculino') //id 3
	}	
	
	def get(id){
		return this.espectadores.find{ it.id == id }
	}
	
}
