package festivalRock_View

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow
import aplicationModel.BuscadorClientes
import dominio.Compra
import dominio.Comprador
import dominio.Entrada;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.lacar.ui.model.Action
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

class BuscarEntradasPorClienteWindow extends SimpleWindow<BuscadorClientes>{
	
	BuscarEntradasPorClienteWindow(WindowOwner owner){
		super(owner, new BuscadorClientes())
		modelObject.search()
	}
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		title = "Entradas Vendidas por Cliente"
		taskDescription = "Ingrese los parametros de busqueda"

		super.createMainTemplate(mainPanel)

		this.createResultsGrid(mainPanel)
	//	this.createGridActions(mainPanel)
	}
	
	protected void createResultsGrid(Panel mainPanel) {
		def table = new Table<Compra>(mainPanel, Compra.class)
		table.with {
			heigth = 200
			width = 600
			bindItemsToProperty("resultados")
			
		}
		this.describeResultsGrid(table)
	}
	
	protected void describeResultsGrid(Table<Compra> table) {
		new Column<Compra>(table) //
				.setTitle("Fecha")
				.setFixedSize(150)
				.bindContentsToProperty("fechaCompra")

		new Column<Compra>(table) //
				.setTitle("Compras")
				.setFixedSize(100)
				.bindContentsToProperty("entradasCompradas")

	}

	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
				.setCaption("Buscar")
				.onClick({ modelObject.search() } as Action)
				.setAsDefault()
				.disableOnError()

		new Button(actionsPanel) //
				.setCaption("Limpiar")
				.onClick({ modelObject.clear() } as Action)
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel)
		searchFormPanel.setLayout(new ColumnLayout(2))
		
		new Label(searchFormPanel).setText("Ingrese apellido");
		new TextBox(searchFormPanel).bindValueToProperty("apellido")
		new Label(searchFormPanel).setText("Ingrese nombre");
		new TextBox(searchFormPanel).bindValueToProperty("nombre")
	}

	
}
