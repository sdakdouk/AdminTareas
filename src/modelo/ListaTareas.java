package modelo;
import java.util.ArrayList;
import tarea_DAO.DAO_Tarea;


public class ListaTareas {

		private ArrayList<Tarea> lista;		
		
		
		
		public ListaTareas() {
			super();
			this.lista = new ArrayList<Tarea>();
		}
		
		public ArrayList<Tarea> obtenerTareas(){
			try {
				lista = DAO_Tarea.getInstance().listaTareas();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}
		public String pintarLista() {
			String texto="";
			texto="  <thead class='thead-dark text-uppercase font-weight-bold'>" + 
					"<tr><th scope=\"col\">id</th><th scope=\"col\">Titulo</th><th scope=\"col\">Descripcion</th><th scope=\"col\">Categoria</th>"
					+"<th scope=\"col\">Dependencia</th><th scope=\"col\">Importancia</th><th scope=\"col\">Estado</th>"
					+ "<th scope=\"col\">Fecha inicio</th><th scope=\"col\">Fecha fin</th><th scope=\"col\">Editar</th><th scope=\"col\">Eliminar</th></tr></thead>" ;	
			for(Tarea t : lista) {
				texto+=t.imprimir();
			}

			return texto;
			
		}
		public String DependenLista() {
			String texto= "<option value='0'>Seleccione</option>";
			for(Tarea t : lista) {
				texto+=t.dependencia();
			}
			return texto;
		}
		
		
		
	}


