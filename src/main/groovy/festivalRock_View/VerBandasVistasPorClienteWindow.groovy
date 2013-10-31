package festivalRock_View

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.lacar.ui.model.Action
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import aplicationModel.BuscadorBandasPorCliente
import aplicationModel.BuscadorPuestoVentas;
import dominio.Compra;
import dominio.Entrada
import dominio.Noche
import dominio.PuestoDeVenta

class VerBandasVistasPorClienteWindow extends SimpleWindow<BuscadorBandasPorCliente>{
	
	VerBandasVistasPorClienteWindow(WindowOwner owner){
		super(owner, new BuscadorBandasPorCliente())
		modelObject.search()
	}
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		title = "Bandas Vistas Por Cliente"
		taskDescription = "Ingrese los parametros de busqueda"

		super.createMainTemplate(mainPanel)

		this.createResultsGrid(mainPanel)
		//this.createGridActions(mainPanel)
	}
	
	protected void createResultsGrid(Panel mainPanel) {
		def table = new Table<Noche>(mainPanel, Noche.class)
		table.with {
			heigth = 200
			width = 600
			bindItemsToProperty("resultados")
			
		}
		this.describeResultsGrid(table)
	}
	
	def describeResultsGrid(Table<Noche> table) {
		new Column<Noche>(table)
						.setTitle("Fecha")
						.setFixedSize(150)
						.bindContentsToProperty("fecha")
			
		/*new Column<Noche>(table)
						.setTitle("Butacas (numero-sector-fila)")
						.setFixedSize(200)
						.bindContentsToProperty("butacas")*/
						
		new Column<Noche>(table)
						.setTitle("Bandas")
						.setFixedSize(200)
						.bindContentsToProperty("bandas")
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel)
		searchFormPanel.setLayout(new ColumnLayout(2))
		
		new Label(searchFormPanel).setText("Ingrese el nombre");
		new TextBox(searchFormPanel).bindValueToProperty("nombre")
		new Label(searchFormPanel).setText("Ingrese el apellido");
		new TextBox(searchFormPanel).bindValueToProperty("apellido")

//		new Label(searchFormPanel).with {
//			text = "Puesto de Venta"
//			foreground = Color.BLUE
//		}
//		new TextBox(searchFormPanel).bindValueToProperty("id")
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

}
