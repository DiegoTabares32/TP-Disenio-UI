package festivalRock_View

import dominio.Butaca

import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.lacar.ui.model.Action



class ComprarEntrada extends SimpleWindow<Butaca>{
	
	public ComprarEntrada(owner, model) {
		super(owner, model)
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel)
		form.with {
			layout = new ColumnLayout(2)
			new Label(it).text = "Número de Butaca"
			new Label(it).bindValueToProperty("numeroButaca")
			new Label(it).text = "Ubicacion"
			new Label(it).bindValueToProperty("ubicacion")
			
			}
			new Label(form).text = "Recibe resumen cuenta en domicilio"
			new CheckBox(form)
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}


}
