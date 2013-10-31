package dominio

import javax.annotation.Generated;

import groovy.transform.TupleConstructor;
import org.uqbar.commons.utils.Observable

@Observable
class Banda {
	//XXX ojo, esto es un dto (data transfer object). No digo que este mal, sino solo que tengan cuidado 
	//de hacer esto
	
	static def ID = 1
	
	def id
	def nombreBanda
	def categoria
	def precioCategoria
	
	def Banda(def nombre, def categoria, def precio){
		this.id = ID
		this.nombreBanda = nombre
		this.categoria = categoria
		this.precioCategoria = precio
		ID++
	}
	
	@Override
	public String toString(){
		 // y aca pones los atributos que quieras mostrar por ejemplo
		  this.nombreBanda + "-" + this.categoria
	}
}
