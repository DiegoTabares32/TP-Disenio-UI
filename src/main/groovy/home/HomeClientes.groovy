package home

import dominio.Banda
import dominio.Compra
import dominio.Comprador
import dominio.Entrada
import dominio.Espectador

class HomeClientes {

	static def homeUbicaciones = HomeUbicaciones.INSTANCE
	static def homeButacas = HomeButacas.INSTANCE
	static def homeNoches = HomeNoches.INSTANCE
	static def INSTANCE = getInstance()
	def clientes = [] as Set

	private HomeClientes(){
		super()
		this.init()
	}

	static def HomeClientes getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomeClientes()
		}
		return INSTANCE
	}

	def getIds(){
		def allIDs = clientes.collect{ it.id}
		return allIDs
		//return allIDs.unique(false)
	}

	def init(){

		def banda1 = new Banda("Radiohead", 4, 200)

		def cliente1 = new Comprador("Juan", "Perez")
		def cliente2 = new Comprador("John", "Smith")
		//def cliente3 = new Comprador("Juana", "Gonzalez")
		//def cliente4 = new Comprador("Jane", "Doe")

		def espectador1 = new Espectador('Jonas', 'Castillo', 23, 'Masculino')
		def espectador2 = new Espectador('Melina', 'Miranda', 23, 'Femenino')
		def espectador3 = new Espectador("Juan", "Perez", 25, 'Masculino')

		def entrada1 = new Entrada(cliente1, espectador1, homeUbicaciones.get(1), homeButacas.get(1), banda1, homeNoches.get(1))
		def entrada2 = new Entrada(cliente1, espectador2, homeUbicaciones.get(2), homeButacas.get(2), banda1, homeNoches.get(2))
		def entrada3 = new Entrada(cliente1, espectador3, homeUbicaciones.get(3), homeButacas.get(3), banda1, homeNoches.get(3))
		def entrada4 = new Entrada(cliente1, espectador1, homeUbicaciones.get(6), homeButacas.get(6), banda1, homeNoches.get(4))

		def compra1 = new Compra()
		def compra2 = new Compra()
		def compra3 = new Compra()

		compra1.fechaCompra = Date.parse( "yyyy-MM-dd", "2013-05-09" )
		compra1.entradasCompradas <<  [entrada1, entrada2]
		compra2.fechaCompra = Date.parse( "yyyy-MM-dd", "2013-08-08" )
		compra2.entradasCompradas << entrada3
		compra3.fechaCompra = Date.parse( "yyyy-MM-dd", "2013-06-17" )
		compra3.entradasCompradas << entrada4


		clientes << [cliente1, cliente2]

	}

	def search(nombre, apellido){
		
		return	this.clientes.find{ it -> it.nombre == nombre && it.apellido == apellido}
		
	}
	
	def flitarPorFecha(cliente, fechaInicio, fechaFin){
		def fechaInicioParse = Date.parse( "yyyy-MM-dd", fechaInicio )
		def fechaFinParse = Date.parse( "yyyy-MM-dd", fechaFin )
		def comprasFiltradas = []
		comprasFiltradas = cliente.compras.findAll{it -> it > fechaInicioParse && it < fechaFinParse}
		return comprasFiltradas.sort()
	}
}
