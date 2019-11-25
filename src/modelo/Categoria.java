package modelo;

import java.sql.SQLException;

import tarea_DAO.DAO_Categoria;

public class Categoria {
	
	private int id;
	private String nombre;
	
	public Categoria() {
		
	}
	public Categoria( String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String ListaCatO() {
		String texto = "<option value="+getId()+">"+getNombre()+"</option>"; 
		return texto;
	}
	public 	String imprimirTabla() {
		
		String texto="<tbody>";
			texto+="<tr class='text-muted'><td class='table-primary'>"+getId()+"</td>";
			texto+="<td>"+getNombre()+"</td>";
			texto+="<td><a href='AltaCategoria?opcion=3&id="+getId()+"'><i class=\"fas fa-edit\"></i></a></td>";
			texto+="<td><a href='AltaCategoria?opcion=2&id="+getId()+"'><i class='fas fa-trash-alt'></i></a></td></tr></tbody>";

	

		return texto;
	}

	public void buscarID(int id) {
		Categoria e = null;
		try {
			e = DAO_Categoria.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id=e.getId();
			this.nombre=e.getNombre();
		}
	}

	public void insertar() {
		try {
			DAO_Categoria.getInstance().insert(this);
			//System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void borrar() {
		try {
			DAO_Categoria.getInstance().delete(this);
			//System.out.println("Registro eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		try {
			DAO_Categoria.getInstance().update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
}
