package dominio
import org.uqbar.commons.utils.Observable;

@Observable
class Comprador {
	
	
	def static ID = 1
	
	def id
	def nombre
	def apellido
	def compras = []

	/*
	 * Inicializador
	 */
	
	def Comprador(nombre, apellido){
		this.nombre = nombre
		this.apellido = apellido
		this.id = ID
		ID++
	}
	
	/*
	 * Metodos Compra
	 */

	def agregarCompra(compra){
		this.compras << compra
	}
	
	//PARA MOSTRAR LOS DATOS
	@Override
	public String toString() {
		return this.nombre+' '+this.apellido
	}
}
