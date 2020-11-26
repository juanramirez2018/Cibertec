package net.muni.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.muni.entidad.Usuario;
import net.muni.service.ModelUsuario;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	
	ModelUsuario mu=new ModelUsuario();
	
	private static final long serialVersionUID = 1L;
       

    public ServletUsuario() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login,clave;
		login=request.getParameter("user");
		clave=request.getParameter("pass");
		Usuario us=mu.iniciarSesion(login, clave);
		
		if(us==null){
			request.setAttribute("msj", "* usuario o clave incorrecto");
			request.getRequestDispatcher("index.jsp").forward(
			request,response);
		}
		else{
		response.sendRedirect("usuario.jsp");
		}
	}

}
