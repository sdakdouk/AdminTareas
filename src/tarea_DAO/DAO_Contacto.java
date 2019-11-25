package tarea_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import coneccion.DBConnection;
import modelo.Contacto;

public class DAO_Contacto {
	private Connection con = null;

	public static DAO_Contacto instance = null;

	public DAO_Contacto() throws SQLException{
		con = (Connection) DBConnection.getConnection();
	}

	public static DAO_Contacto getInstance() throws SQLException  {
		if (instance == null)
			instance = new DAO_Contacto();
		return instance;
	}

	public void insert(Contacto c) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Contacto"
				+ " (nombre, apellido, mail, clave) VALUES (?,?,?,?)");
		ps.setString(1, c.getNombre());
		ps.setString(2, c.getApellido());
		ps.setString(3, c.getMail());
		ps.setString(4, c.getClave());
		ps.executeUpdate();
		ps.close();
	}

}
