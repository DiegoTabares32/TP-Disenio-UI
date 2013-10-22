package festivalRock_View

import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.lacar.ui.model.Action

import aplicationModel.BuscadorEntradas;

import dominio.Entrada
import dominio.Planificacion

class BuscarButacaVipWindow  extends SimpleWindow<BuscadorEntradas>{
	
	BuscarButacaVipWindow(WindowOwner owner) {
		super(owner, new BuscadorEntradas())
		modelObject.buscar()
	}

	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		title = "Buscador de Entradas Vip"
		taskDescription = "Ingrese los parÃ¡metros de bÃºsqueda"

		super.createMainTemplate(mainPanel)

		this.createResultsGrid(mainPanel)
		this.createGridActions(mainPanel)
	}
	
	// *************************************************************************
	// ** RESULTADOS DE LA BUSQUEDA
	// *************************************************************************

	/**
	 * Se crea la grilla en el panel de abajo El binding es: el contenido de la grilla en base a los
	 * resultados de la bÃºsqueda Cuando el usuario presiona Buscar, se actualiza el model, y Ã©ste a su vez
	 * dispara la notificaciÃ³n a la grilla que funciona como Observer
	 */
	protected void createResultsGrid(Panel mainPanel) {
		def table = new Table<Entrada>(mainPanel, Entrada.class)
		table.with {
			heigth = 200
			width = 450
			bindItemsToProperty("resultados")
			bindValueToProperty("entradaSeleccionada")
		}
		this.describeResultsGrid(table)
	}
	
	/**
	 * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
	 * en el caso del nÃºmero o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
	 * (generalmente String), como en el caso de Recibe Resumen de Cuenta
	 *
	 * @param table
	 */
	protected void describeResultsGrid(Table<Entrada> table) {
		new Column<Entrada>(table) //
				.setTitle("Comprador")
				.setFixedSize(150)
				.bindContentsToProperty("comprador")

		new Column<Entrada>(table) //
				.setTitle("Espectador")
				.setFixedSize(100)
				.bindContentsToProperty("espectador")

//		Column<Entrada> modeloColumn = new Column<Entrada>(table)
//		modeloColumn.setTitle("Modelo")
//		modeloColumn.setFixedSize(150)
//		modeloColumn.bindContentsToProperty("modeloCelular")
//
//		Column<Entrada> ingresoColumn = new Column<Entrada>(table)
//		ingresoColumn.setTitle("Recibe resumen de cuenta")
//		ingresoColumn.setFixedSize(50)
//		// TODO: Ver si lo bindeo contra org.uqbar.Transformer
//		ingresoColumn.bindContentsToTransformer({ celular -> celular.recibeResumenCuenta ? "SI" : "NO"} as Transformer<Entrada, String>)
	}
	
	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel)
		actionsPanel.setLayout(new HorizontalLayout())

		Button edit = new Button(actionsPanel)
		edit.setCaption("Editar")
		edit.onClick({ this.modificarCelular() } as Action)

		Button remove = new Button(actionsPanel)
		remove.setCaption("Borrar")
		remove.onClick( { modelObject.eliminarCelularSeleccionado() } as Action)

		// Deshabilitar los botones si no hay ningÃºn elemento seleccionado en la grilla.
		NotNullObservable elementSelected = new NotNullObservable("entradaSeleccionada")
		remove.bindEnabled(elementSelected)
		edit.bindEnabled(elementSelected)
	}
	
//	@Override
//	public void createContents(Panel mainPanel) {
//		// TODO Auto-generated method stub
//		mainPanel.with {
//			title = "Buscador de Butacas Vip"
//			layout = new HorizontalLayout()
//			new Button(mainPanel)
//			.setCaption("Volver")
//			.onClick({this.close()} as Action)
//		}
//		
//	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

}
