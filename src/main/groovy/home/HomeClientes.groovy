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
	static def homeEspectadores = HomeEspectadores.INSTANCE
	static def homeBandas = HomeBandas.INSTANCE
	static def homeEntrada = HomeEntrada.INSTANCE
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

		def cliente1 = new Comprador("Testa", "Ferro") //id 1
		def cliente2 = new Comprador("Jonas", "Castillo") //id 2
		//def cliente3 = new Comprador("Juana", "Gonzalez")
		//def cliente4 = new Comprador("Jane", "Doe")

		def entrada1 = new Entrada(cliente1, homeEspectadores.get(1), homeUbicaciones.get(1), homeButacas.get(1), homeBandas.get(1), homeNoches.get(1))
		def entrada2 = new Entrada(cliente1, homeEspectadores.get(3), homeUbicaciones.get(2), homeButacas.get(2), homeBandas.get(2), homeNoches.get(2))
		def entrada3 = new Entrada(cliente1, homeEspectadores.get(2), homeUbicaciones.get(3), homeButacas.get(3), homeBandas.get(1), homeNoches.get(3))
		def entrada4 = new Entrada(cliente1, homeEspectadores.get(1), homeUbicaciones.get(6), homeButacas.get(6), homeBandas.get(1), homeNoches.get(4))
		
		homeEntrada.agregarEntrada(entrada1)
		homeEntrada.agregarEntrada(entrada2)
		homeEntrada.agregarEntrada(entrada3)
		homeEntrada.agregarEntrada(entrada4)
		
		def compra1 = new Compra()
		def compra2 = new Compra()
		def compra3 = new Compra()

		compra1.fechaCompra = Date.parse( "yyyy-MM-dd", "2012-05-09" )
		compra1.entradasCompradas <<  [entrada1, entrada2]
		compra2.fechaCompra = Date.parse( "yyyy-MM-dd", "2013-08-08" )
		compra2.entradasCompradas << entrada3
		compra3.fechaCompra = Date.parse( "yyyy-MM-dd", "2013-06-17" )
		compra3.entradasCompradas << entrada4

		cliente1.compras << compra1
		cliente1.compras << compra2
		cliente2.compras << compra3

		clientes << cliente1
		clientes << cliente2

	}

	def get(def id){
		return this.clientes.find{noche -> noche.id == id}
	}	
	
	def search(nombre, apellido){
		def cliente
		cliente = this.clientes.find{ it -> it.nombre == nombre && it.apellido == apellido}
		if (cliente != null)
			cliente.compras
	}

	def filtrarPorFecha(nombre, apellido, fechaInicio, fechaFin){
		if (fechaInicio != null & fechaFin != null){
			def comprasSinFiltrar = []
			comprasSinFiltrar = this.search(nombre, apellido)
			def comprasFiltradas = []
			def fechaInicioParse = Date.parse( "dd/MM/yyyy", fechaInicio )
			def fechaFinParse = Date.parse( "dd/MM/yyyy", fechaFin )
			comprasFiltradas = comprasSinFiltrar.findAll{it -> it.fechaCompra > fechaInicioParse && it.fechaCompra < fechaFinParse}
			//return comprasFiltradas.sort()
		}
	}
}
