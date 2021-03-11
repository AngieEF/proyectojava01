//nombre del paquete
package com.senati.webs.jsps.servlets;
//importando librerias
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.senati.web.jsps.servlet.vo.VOLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginWeb.jr" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	
	// obtener el valor del usuario
	String usuario = request.getParameter("usuario");
	// obtener el valor de la clave
	String clave = request.getParameter("clave");

	// si usuario y clave son correctos
	if (usuario.equals("Angie") && clave.equals("123456")) {
		VOLogin vo= new VOLogin();
		vo.setUsuario(usuario);
		vo.setClave(clave);
		vo.setNombre("Angie Espiritu Fernandez");
		vo.setEdad(18);
		System.out.println("Bienvenida " + usuario);
		HttpSession session= request.getSession(true);
		session.setAttribute("usuarioLogueado",vo);
		request.getRequestDispatcher("bienvenida.jsp").forward(request,response);
	}else {
		System.out.println("No tiene acceso");
		//response.sendRedirect("login.html");
		
	}
 
}
}
