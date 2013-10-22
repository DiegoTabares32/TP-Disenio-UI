package festivalRock_View

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.lacar.ui.model.Action

import dominio.Planificacion

class BuscadorWindow extends MainWindow<Planificacion>{
		
	BuscadorWindow(){
		
		super(new Planificacion());
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		
		mainPanel.with {
			title = "Bienvenido a la app de \\m/ Festival de Rock \\m/"
			layout = new VerticalLayout()
		}		
		
		new Label(mainPanel).setText("¿Qué desea hacer?")
		Panel aPanel = new Panel(mainPanel);
		aPanel.setLayout(new HorizontalLayout());
		this.addActions(aPanel)
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
				.setCaption("Buscar Vip")
				.onClick({this.vip()} as Action)	

		new Button(actionsPanel) //
				.setCaption("Buscar Normal")
				.onClick({ this.normal() } as Action)

		new Button(actionsPanel)//
				.setCaption("Comprar Reservadas")
				.onClick({ this.reservadas() } as Action)
		
		new Button(actionsPanel)
				.setCaption("Cancelar Entrada")
				.onClick({ this.cancelar()} as Action)
				
		new Button(actionsPanel)
				.setCaption("Entradas Vendidas en Puesto")
				.onClick({ this.entradasVendidasEnUnPuesto()} as Action)
	}

	def vip(){
		//new BuscarButacaVipWindow(this).open()
	}
	
	def normal(){
				
	}
	
	def reservadas(){
		
	}
	
	def cancelar(){
		
	}
	
	def entradasVendidasEnUnPuesto(){
		new VerEntradasVendidasEnPuesto(this).open()
	}
	
	static void main(String[] args) {
		new BuscadorWindow().startApplication()
	}

}
