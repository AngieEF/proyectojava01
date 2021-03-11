package com.senati.webs.jsps.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senati.web.jsps.servlet.vo.VOLogin;

/**
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/adminUsuarios.servlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String accion= request.getParameter("accion");
		System.out.println("Accion es : " +accion);
		List<VOLogin>lista =(List<VOLogin>)request.getSession().getAttribute("listaUsuario");
		VOLogin vo=new VOLogin();
		vo.setUsuario(request.getParameter("usuario"));
		vo.setClave(request.getParameter("clave"));
		vo.setNombre(request.getParameter("nombre"));
		vo.setEdad(Integer.parseInt(request.getParameter("edad")));
		if (accion.contentEquals("guardar")) {
			lista.add(vo);
		}else if (accion.contentEquals("actualizar")) {
			for (VOLogin obj:lista) {
				if(obj.getUsuario().contentEquals(vo.getUsuario())) {
					obj.setClave(vo.getClave());
					obj.setNombre(vo.getNombre());
					obj.setEdad(vo.getEdad());
				}
		}
		}else if(accion.contentEquals("eliminar")) {
			for (VOLogin obj:lista) {
				if (obj.getUsuario().contentEquals(vo.getUsuario()));
				lista.remove(obj);
			}
		}
	}
	response.sendRedirect("usuarios/usuarios.jsp");
}

	
