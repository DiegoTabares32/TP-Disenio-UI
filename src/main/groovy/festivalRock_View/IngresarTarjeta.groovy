package festivalRock_View

import aplicationModel.RegistroDatos

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow

class IngresarTarjeta extends SimpleWindow<RegistroDatos>{

	def IngresarTarjeta(owner, model){
		super(owner, model)
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		TextBox txt = new TextBox(mainPanel)
		txt.bindValueToProperty("numeroTarjeta")
	}

}
