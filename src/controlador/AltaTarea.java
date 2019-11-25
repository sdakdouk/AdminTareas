package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tarea;
import tarea_DAO.DAO_Tarea;

/**
 * Servlet implementation class AltaTarea
 */
@WebServlet("/AltaTarea")
public class AltaTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTarea() {
        super();
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion =request.getParameter("opcion");
		try {
			switch (opcion) {
			case "1":
				nuevaTarea(request, response);
				break;
			case "2":
				borrarTarea(request, response);
				break;
			case "3":
				buscarTarea(request, response);
				break;
			default:
				System.out.println("Opcion no valida");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}

	private void buscarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("tareas.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("tareas.jsp");
			vista.forward(request, response);
		}
		
	}

	private void borrarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tarea t = new Tarea();
		t.buscarID(Integer.parseInt(request.getParameter("id")));
		t.borrar();
		response.sendRedirect("listaTareas.jsp");
		
	}

	private void nuevaTarea(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String titulo= request.getParameter("titulo");
		String descripcion= request.getParameter("descripcion");
		Integer categoria= Integer.parseInt(request.getParameter("categoria"));
		Integer importancia= Integer.parseInt(request.getParameter("importancia"));
		Integer depende= Integer.parseInt(request.getParameter("depende"));
		Integer estado= Integer.parseInt(request.getParameter("estado"));
		LocalDate fecha_inicio = LocalDate.parse(request.getParameter("fecha_inicio"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate fecha_fin = LocalDate.parse(request.getParameter("fecha_fin"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


         Tarea t= new Tarea(titulo,descripcion,categoria,importancia,depende,fecha_inicio, fecha_fin, estado);	
		
		if (request.getParameter("id") != "") {
			try {
				t.setId(Integer.parseInt(request.getParameter("id")));
				t.actualizar();
				}catch (NumberFormatException e){
		       System.out.println("not a number"); 
		   } 
			
		} else
			t.insertar();
	    
		response.sendRedirect("listaTareas.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
