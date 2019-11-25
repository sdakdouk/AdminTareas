package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import tarea_DAO.DAO_Tarea;

public class Tarea {
	private int id;
	private String titulo;
	private String descripcion;
	private Integer importante;
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;

	private DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Integer categoria;
	private Integer depende;
	private Integer estado;
	
	
	public Tarea() {
		
	}
	public Tarea(int id, String titulo, String descripcion, Integer importante,Integer categoria,Integer depende, LocalDate  fecha_inicio, LocalDate  fecha_fin, Integer estado) {
		super();
		this.id=id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.importante = importante;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.categoria = categoria;
		this.depende=depende;
		this.estado=estado;
	}

	public Tarea( String titulo, String descripcion, Integer importante,Integer categoria,Integer depende, LocalDate fecha_inicio, LocalDate fecha_fin,Integer estado ) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.importante = importante;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.categoria = categoria;
		this.depende=depende;
		this.estado=estado;
	}
	public Tarea(String titulo, String descripcion, Integer categoria, Integer importancia, Integer depende, Integer estado) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.importante = importancia;
		this.categoria = categoria;
		this.depende=depende;
		this.estado=estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setImportante(Integer importante) {
		this.importante = importante;
	}
	
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public String fechaFormatddmmyyyy() {
		return formateo.format(fecha_inicio);
	}
	
	public void setFecha_inicio(LocalDate fecha) {
		this.fecha_inicio = fecha;
	}
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public String ffechaFormatddmmyyyy() {
		return formateo.format(fecha_fin);
	}
	
	public void setFecha_fin(LocalDate fecha) {
		this.fecha_fin = fecha;
	}
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public Integer getDepende() {
		return depende;
	}
	public void setDepende(Integer depende) {
		this.depende = depende;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getImportante() {
		return importante;
	}
	
	public void buscarID(int id) {
		Tarea t = null;
		try {
			t = DAO_Tarea.getInstance().buscarID(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (t != null) {
			this.id = t.getId();
			this.titulo = t.getTitulo();
			this.descripcion = t.getDescripcion();
			this.categoria = t.getCategoria();
			this.importante = t.getImportante();
			this.depende = t.getDepende();
			this.fecha_inicio = t.getFecha_inicio();
			this.fecha_fin = t.getFecha_fin();
			this.estado = t.getEstado();
		}
	}
	public void actualizar() {
		try {
			DAO_Tarea.getInstance().update(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertar(){
		try {
			DAO_Tarea.getInstance().insert(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void borrar() {
	try {
		DAO_Tarea.getInstance().delete(this);
		//System.out.println("Registro eliminado");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public String dependencia() {
		String texto = "<option value="+getId()+">"+getTitulo()+"</option>"; 
		return texto;
	}
	public String imprimir() {
		String texto="<tbody>";
		texto+="<tr class='text-muted'><td class='table-primary'>"+getId()+"</td>";
		texto+="<td>"+getTitulo()+"</td>";
		texto+="<td>"+getDescripcion()+"</td>";
		texto+="<td>"+getCategoria()+"</td>";
		texto+="<td>"+getDepende()+"</td>";
		texto+="<td>"+getImportante()+"</td>";
		texto+="<td>"+getEstado()+"</td>";
		texto+="<td>"+fechaFormatddmmyyyy()+"</td>";
		texto+="<td>"+ffechaFormatddmmyyyy()+"</td>";
		texto+="<td><a href='AltaTarea?opcion=3&id="+getId()+"'><i class=\"fas fa-edit\"></i></a></td>";
		texto+="<td><a href='AltaTarea?opcion=2&id="+getId()+"'><i class='fas fa-trash-alt'></i></a></td></tr></tbody>";

		return texto;
	}
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", importante=" + importante
				+ ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", categoria=" + categoria
				+ ", depende=" + depende + ", estado=" + estado + "]";
	}
	
	
	

}
