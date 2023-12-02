
package com.emergentes.servlet;

import com.emergentes.BEAN.BeanCliente;
import com.emergentes.controladores.exceptions.NonexistentEntityException;
import com.emergentes.entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;

@WebServlet(name = "clientesServlet", urlPatterns = {"/clientesServlet"})
public class clientesServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            BeanCliente daocli = new BeanCliente();
            Cliente cli = new Cliente();
            int id;
            switch(action){
                case "delete":
            id= Integer.parseInt(request.getParameter("id"));
                daocli.eliminar(id);
               response.sendRedirect("clientesServlet");

                    break;

                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    cli=daocli.buscar(id);
                    request.setAttribute("clientes", cli);
                    request.getRequestDispatcher("registroClinetes.jsp").forward(request, response);
                    
            break;
            case "nuevo":
                    
                    request.setAttribute("clientes",cli);
                    request.getRequestDispatcher("registroClinetes.jsp").forward(request, response);
                    break;
            case "view":

               BeanCliente daoHabitacion = new BeanCliente();
               List<Cliente> lista = daoHabitacion.listartodo();
                request.setAttribute("ver", lista);
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
          default:
                break;
            
    }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BeanCliente daocli = new BeanCliente();
        
        int idCliente =Integer.parseInt(request.getParameter("idCliente"));
        String nombre=request.getParameter("nombre");
        String correo= request.getParameter("correo");
        String telefono =request.getParameter("telefono");
        
        
        Cliente cli= new Cliente();
        cli.setIdCliente(idCliente);
        cli.setNombre(nombre);
       cli.setCorreo(correo);
       cli.setTelefono(telefono);
       
if(idCliente >0){
    
      daocli.editar(cli);
}else{ daocli.insertar(cli);
}
response.sendRedirect("habitacionesServlet");

    }

  
}

