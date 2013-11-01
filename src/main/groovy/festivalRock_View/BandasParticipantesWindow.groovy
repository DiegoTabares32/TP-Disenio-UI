package festivalRock_View

import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action

import aplicationModel.BuscadorDeBandas
import dominio.Banda
import dominio.Noche
import dominio.Planificacion;

class BandasParticipantesWindow extends SimpleWindow<BuscadorDeBandas> {
	
	BandasParticipantesWindow (WindowOwner owner) {
		super(owner, new BuscadorDeBandas())

	//	modelObject.search()
	}
	
	@Override
	public void createContents(Panel mainPanel) { 
		
		Panel panel = new Panel(mainPanel)
		panel.setLayout(new HorizontalLayout())
		new Label(panel).setText("Ingrese los parametros de busqueda")
		
		mainPanel.setLayout(new VerticalLayout())
		
		this.createFormPanel(mainPanel)
	
		
		this.createResultsGrid(mainPanel)	
		
		
		Panel actionsPanel = new Panel(mainPanel)
		actionsPanel.setLayout(new HorizontalLayout())
		this.addActions(actionsPanel)
	}


	
	@Override
	protected void createFormPanel(Panel mainPanel){
		Panel searchFormPanel = new Panel(mainPanel)
		searchFormPanel.setLayout(new ColumnLayout(2))
		
		new Label(searchFormPanel).with {
				text = "Nombre de banda: "
			}
		//new TextBox(searchFormPanel).bindValueToProperty("nombre")
		Selector<BuscadorDeBandas> unSelector = new Selector<Banda>(searchFormPanel).allowNull(false);
		unSelector.bindValueToProperty("nombre");
		unSelector.bindItemsToProperty("nombres")
	
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
			
			new Button(actionsPanel)
				.setCaption("Buscar")
				.onClick({ modelObject.search() } as Action)
				
			new Button(actionsPanel)
				.setCaption("Volver")
				.onClick({this.close()} as Action)
	
	}
	
	
	//*****************************************************
	//RESULTADOS DE LA BUSQUEDA
	//*****************************************************
	
	def createResultsGrid (Panel mainPanel) {
		def table = new Table<Noche>(mainPanel, Noche.class)
		table.with {
			heigth = 200
			width = 600
			bindItemsToProperty("resultados")
			//bindValueToProperty()
		}
		this.describeResultsGrid(table)
	}
	
	def describeResultsGrid(Table<Noche> table) {  
		new Column<Noche>(table)
						.setTitle("Fecha")
						.setFixedSize(150)
						.bindContentsToProperty("fecha")
			
		new Column<Noche>(table)  
						.setTitle("Butacas (numero-sector-fila)")
						.setFixedSize(200)
						.bindContentsToProperty("butacas")
						
		new Column<Noche>(table)
						.setTitle("Bandas")
						.setFixedSize(200)
						.bindContentsToProperty("bandas")
	}


		
}
