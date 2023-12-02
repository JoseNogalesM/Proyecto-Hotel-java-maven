
package com.emergentes.servlet;

import com.emergentes.BEAN.BeanHabitacion;
import com.emergentes.entidades.Habitacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nogal
 */
@WebServlet(name = "habitacionesServlet", urlPatterns = {"/habitacionesServlet"})
public class habitacionesServlet extends HttpServlet {

   
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            BeanHabitacion daocli = new BeanHabitacion();
            Habitacion habi= new Habitacion();
            int id;       
        
        switch (action) {
                    case "view":

               BeanHabitacion daoHabitacion = new BeanHabitacion();
               List<Habitacion> lista = daoHabitacion.listartodo();
                request.setAttribute("habi", lista);
                    request.getRequestDispatcher("habitaciones.jsp").forward(request, response);
            default:
                break;
                   case "delete":
            id= Integer.parseInt(request.getParameter("id"));
                daocli.eliminar(id);
               response.sendRedirect("habitacionesServlet");

                    break;

                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    habi=daocli.buscar(id);
                    request.setAttribute("habii", habi);
                    request.getRequestDispatcher("editar-habitacion.jsp").forward(request, response);
                    
            break;
            case "nuevo":
                    
                    request.setAttribute("habii",habi);
                    request.getRequestDispatcher("editar-habitacion.jsp").forward(request, response);
                    break;
                }
                 

     

    
}  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        BeanHabitacion daocli = new BeanHabitacion();
        
        int idhabi =Integer.parseInt(request.getParameter("idHabitacion"));
        int numero =Integer.parseInt(request.getParameter("numero"));
                String tipo= request.getParameter("tipo");

        int precio= Integer.parseInt(request.getParameter("precio"));
       int disponible =Integer.parseInt(request.getParameter("disponible"));
        
        
        Habitacion cli= new Habitacion();
       cli.setIdHabitacion(idhabi);
       cli.setTipo(tipo);
       cli.setNumero(numero);
       cli.setPrecio(precio);
       cli.setDisponible(disponible);
       
if(idhabi >0){
    
      daocli.editar(cli);
}else{ daocli.insertar(cli);
}
response.sendRedirect("habitacionesServlet");

    }

    }


   

