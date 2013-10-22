package home

import com.sun.org.apache.bcel.internal.generic.RETURN;

import dominio.Banda
import dominio.Butaca
import dominio.Comprador
import dominio.Entrada
import dominio.Espectador
import dominio.Noche
import dominio.Ubicacion

class HomeEntrada {
	
	def entradas = [] as Set
	static def INSTANCE = new HomeEntrada()
	
	private HomeEntrada(){
		super()	
		this.init()	
	}
	
	def init(){
		def ubicacion = new Ubicacion("azul", 5)
		def butacas = new Butaca(23, ubicacion, null)
		def banda1 = new Banda("Radiohead", 4, 200)
		this.entradas << new Entrada(
						new Comprador('Testa','Ferro'), new Espectador ('Jonas', 'Castillo', 23, 'Masculino'),
						ubicacion, butacas, banda1,	new Noche( '13/09/2013', butacas, banda1))
		this.entradas << new Entrada(
			new Comprador('Juan','Gomez'), new Espectador ('Julio', 'Cruz', 23, 'Masculino'),
			ubicacion, butacas, banda1,	new Noche( '13/09/2013', butacas, banda1))
		this.entradas << new Entrada(
			new Comprador('Tesone','Pablo'), new Espectador ('Gabriela', 'Saballa', 23, 'Masculino'),
			ubicacion, butacas, banda1,	new Noche( '13/09/2013', butacas, banda1))
	}
	
	def buscar(def fecha){
//		entradas.findAll {
//			entrada -> entrada.getFecha().equals(fecha)
//		}
		return this.entradas
	}
}
