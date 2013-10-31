package home

import dominio.Banda
import dominio.Butaca
import dominio.Compra
import dominio.Comprador
import dominio.Entrada
import dominio.Espectador
import dominio.Noche
import dominio.Ubicacion

class HomeBandasPorCliente {
	
	static def INSTANCE = getInstance()
	def espectadores = [] as Set
	def noches = [] as Set
	def entradas = [] as Set
	def fechas = [] as Set
	
	private HomeBandasPorCliente(){
		super()
		this.init()
	}
	
	static def HomeBandasPorCliente getInstance(){
		if(INSTANCE == null){
			INSTANCE = new HomeBandasPorCliente()
		}
		return INSTANCE
	}
	
	def getIds(){
		def allIDs = clientes.collect{ it.id}
		return allIDs
		//return allIDs.unique(false)
	}
	
	def init(){
		
		def ubicacion1 = new Ubicacion("verde", 8)
		def ubicacion2 = new Ubicacion("verde", 5)
		def ubicacion3 = new Ubicacion("rojo", 7)
		
		def butacas = [] as Set
		def butaca1 = new Butaca(6, ubicacion1, null)
		def butaca2 = new Butaca(7, ubicacion2, null)
		def butaca3 = new Butaca(9, ubicacion3, null)
		
		butacas << butaca1
		butacas << butaca2
		butacas << butaca3
		
		def banda1 = new Banda("Black Sabbath", 5, 200)
		def banda2 = new Banda("Metallica", 4, 180)
		def banda3 = new Banda("Iron Maiden", 4, 180)
		
		def bandas1 = [] as Set
		bandas1 << banda1
		bandas1 << banda3
		
		def bandas2 = [] as Set
		bandas2 << banda2
		bandas2 << banda3
		def noche1 = new Noche('12/12/2012', butacas, bandas1)
		def noche2 = new Noche('13/12/2012', butacas, bandas2)
		
		fechas << noche1.fecha
		fechas << noche2.fecha
		
		/*def noches1 = [] as Set
		noches1 << noche1
		def noches2 = [] as Set 
		noches2 << noche2
		noches << noche2 */
				def cliente1 = new Comprador("Luis", "Gomez")
				def cliente2 = new Comprador("Pedro", "Sanchez")
				//def cliente3 = new Comprador("Juana", "Gonzalez")
				//def cliente4 = new Comprador("Jane", "Doe")
		
				
				
				
				
				def espectador1 = new Espectador('Jonas', 'Castillo', 23, 'Masculino')
				def espectador2 = new Espectador('Melina', 'Miranda', 23, 'Femenino')
				def espectador3 = new Espectador("Juan", "Perez", 25, 'Masculino')
		
				def entrada1 = new Entrada(cliente1, espectador1, ubicacion1, butaca1, banda1, noche1)
				def entrada2 = new Entrada(cliente2, espectador2, ubicacion2, butaca2, banda1, noche2)
				def entrada3 = new Entrada(cliente1, espectador3, ubicacion3, butaca3, banda1, noche1)
		
				entradas << entrada1
				entradas << entrada2
				entradas << entrada3
				
				/*def compra1 = new Compra()
				def compra2 = new Compra()
				def compra3 = new Compra()
		
				compra1.fechaCompra = Date.parse( "yyyy-MM-dd", "2012-05-09" )
				compra1.entradasCompradas <<  [entrada1, entrada2]
				compra2.fechaCompra = Date.parse( "yyyy-MM-dd", "2013-08-08" )
				compra2.entradasCompradas << entrada3*/
			
		
				/*cliente1.compras << compra1
				cliente1.compras << compra2
				cliente2.compras << compra3*/
		
				espectadores << espectador1
				espectadores << espectador2
				espectadores << espectador3
		
			}
	
	def search(nombre, apellido){
		def espectador
		def resultados = [] as Set
		espectador = this.espectadores.find{ it -> it.nombre == nombre && it.apellido == apellido}
		if(espectador != null){
			for(entrada in entradas){
				def espectadorB = entrada.espectador
				if(espectadorB.nombre == espectador.nombre && espectadorB.apellido == espectador.apellido){
					resultados << entrada.noches
					
				}
					
					
			}
				
		}	
		
	   return resultados
	}

}
