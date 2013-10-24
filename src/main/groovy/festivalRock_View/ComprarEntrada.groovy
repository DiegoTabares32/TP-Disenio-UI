package festivalRock_View

import dominio.Butaca

import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;



class ComprarEntrada extends Dialog<Butaca>{
	
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
			
	}

}
