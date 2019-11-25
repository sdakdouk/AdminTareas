package modelo;

import java.sql.SQLException;

import tarea_DAO.DAO_Contacto;

public class Contacto {
	private int id;	
	private String nombre;
	private String apellido;
	private String mail;
	private String clave;

	public Contacto() {
		
	}
	public Contacto(int id, String nombre, String apellido,String mail, String clave) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.mail=mail;
		this.clave=clave;
	}
	public Contacto(String nombre, String apellido,String mail, String clave) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.mail=mail;
		this.clave=clave;		
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public void insertar(){
		try {
			DAO_Contacto.getInstance().insert(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", clave="
				+ clave + "]";
	}

}
