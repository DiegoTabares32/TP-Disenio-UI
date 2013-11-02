package dominio

import groovy.transform.TupleConstructor;
import org.uqbar.commons.utils.Observable;

@Observable
@TupleConstructor
class Espectador {
	
	def static ID = 1
	
	def id
	def nombre
	def apellido
	def edad
	def sexo
	
	def Espectador(nombre, apellido, edad, sexo){
		this.nombre = nombre
		this.apellido = apellido
		this.edad = edad
		this.sexo = sexo
		this.id = ID
		ID++
	}
	
	//PARA MOSTRAR LOS DATOS
	@Override
	public String toString() {
		return this.nombre+' '+this.apellido
	}
}
