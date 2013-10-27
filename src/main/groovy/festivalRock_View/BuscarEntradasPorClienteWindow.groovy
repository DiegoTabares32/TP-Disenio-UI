package festivalRock_View

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow
import aplicationModel.BuscadorClientes
import org.uqbar.arena.windows.WindowOwner;

class BuscarEntradasPorClienteWindow extends SimpleWindow<BuscadorClientes>{
	
	BuscarEntradasPorClienteWindow(WindowOwner owner){
		super(owner, new BuscadorClientes())
		modelObject.search()
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

	
}
