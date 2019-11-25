package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;

/**
 * Servlet implementation class AltaCategoria
 */
@WebServlet("/AltaCategoria")
public class AltaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		switch (request.getParameter("opcion")) {
		case "1":
			nuevaCat(request, response);
			break;
		case "2":
			borrarCat(request, response);
			break;
		case "3":
			buscarCat(request, response);
			break;
		default:
			System.out.println("Opcion no valida");
		}
	}

	private void buscarCat(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("categoria.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("categoria.jsp");
			vista.forward(request, response);
		}
		
		
	}

	private void borrarCat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Categoria c = new Categoria();
		c.buscarID(Integer.parseInt(request.getParameter("id")));
		c.borrar();
		response.sendRedirect("listaCategoria.jsp");
				
	}

	private void nuevaCat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombre = request.getParameter("nombre");
		
		Categoria c = new Categoria(nombre);
		if (request.getParameter("id") != "") {
			int id = Integer.parseInt(request.getParameter("id"));
			c.setId(id);
			c.actualizar();
		} else
			c.insertar();

		response.sendRedirect("listaCategoria.jsp");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
