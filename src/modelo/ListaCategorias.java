package modelo;

import java.util.ArrayList;

import tarea_DAO.DAO_Categoria;
import tarea_DAO.DAO_Tarea;

public class ListaCategorias {
	private ArrayList<Categoria> lista;		
	
	
	
	public ListaCategorias() {
		super();
		this.lista = new ArrayList<Categoria>();
	}
	
	public ArrayList<Categoria> obtenerCat(){
		try {
			lista = DAO_Categoria.getInstance().listaCat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public String pintarLista() {
		String texto="";
		texto="  <thead class='thead-dark text-uppercase font-weight-bold'>" + 
				"<tr><th scope=\"col\">id</th><th scope=\"col\">Nombre</th><th scope=\"col\">Editar</th><th scope=\"col\">Eliminar</th></tr></thead>" ;	
		for(Categoria c : lista) {
			texto+=c.imprimirTabla();
		}

		return texto;
		
	}
	public String CatLista() {
		String texto= "<option value='0'>Seleccione</option>";
		for(Categoria c : lista) {
			texto+=c.ListaCatO();
		}
		return texto;
	}

}
