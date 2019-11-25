package tarea_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coneccion.DBConnection;
import modelo.Categoria;

public class DAO_Categoria {
	private Connection con = null;

	public static DAO_Categoria instance = null;

	public DAO_Categoria() throws SQLException{
		con = (Connection) DBConnection.getConnection();
	}

	public static DAO_Categoria getInstance() throws SQLException  {
		if (instance == null)
			instance = new DAO_Categoria();
		return instance;
	}

	public void insert(Categoria c) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Categoria"
				+ " (nombre) VALUES (?)");
		ps.setString(1, c.getNombre());
		
		ps.executeUpdate();
		ps.close();		
	}

	public void delete(Categoria c) throws SQLException {
		delete(c.getId());
	}
	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM Categoria WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
		
	

	public void update(Categoria c) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE Categoria SET nombre= ? WHERE id = ?");
	
		ps.setString(1, c.getNombre());
		ps.setInt(2, c.getId());
		ps.executeUpdate();
		ps.close();		
	}

	public Categoria buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Categoria WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Categoria result = null;
		if (rs.next()) {
			result = new Categoria(rs.getInt("id"), rs.getString("nombre"));
		}
		rs.close();
		ps.close();
		return result;		
		}

	public ArrayList<Categoria> listaCat() throws SQLException {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();		
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Categoria");
		 ResultSet resultado = ps.executeQuery();
		 
			while(resultado.next()) {
				
				Categoria c = new Categoria(resultado.getInt("id"), resultado.getString("nombre"));
				lista.add(c);
			}
			resultado.close();
			ps.close();	
		
		return lista;
	}

	
	


}
