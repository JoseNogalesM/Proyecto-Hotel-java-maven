
package com.emergentes.servlet;

import com.emergentes.BEAN.BeanCliente;
import com.emergentes.BEAN.BeanHabitacion;
import com.emergentes.BEAN.BeanReserva;
import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Habitacion;
import com.emergentes.entidades.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "reservaServlet", urlPatterns = {"/reservaServlet"})
public class reservaServlet extends HttpServlet {

    
  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
                BeanReserva daores = new BeanReserva();
                BeanCliente daocli = new BeanCliente();// obj para idcliente
                BeanHabitacion daohabi = new BeanHabitacion();//obj para id_habitacion 

Reserva reserva = new Reserva();//libro
List<Cliente> lista;
List<Habitacion> lista2;
        int id;
switch(action){
    case "delete":
                id= Integer.parseInt(request.getParameter("id"));
                daores.eliminar(id);
               response.sendRedirect("reservaServlet");

                break;
     case "edit":
         //
             lista= daocli.listartodo();
         request.setAttribute("reserva", lista);
         //
         //
         lista2=daohabi.listartodo();
         request.setAttribute("habitaciones", lista2);
         
         //
                id=Integer.parseInt(request.getParameter("id"));
                reserva=daores.buscar(id);
                request.setAttribute("reserva", reserva);
                request.getRequestDispatcher("editar-reserva.jsp").forward(request, response);
                break;
     case "nuevo":
         //
         lista= daocli.listartodo();
         request.setAttribute("reserva", lista);
         
         //
         //
         lista2=daohabi.listartodo();
         request.setAttribute("habitaciones", lista2);
         //
                request.setAttribute("reserva",reserva);
                request.getRequestDispatcher("editar-reserva.jsp").forward(request, response);
                break;
     case "view":


                List<Reserva> libros = daores.listartodo();
                request.setAttribute("view", libros);
                request.getRequestDispatcher("reserva.jsp").forward(request, response);
            default:
                break;
}

    }


        

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BeanReserva daoLibro = new BeanReserva();
        //
                        BeanCliente daoCategoria = new BeanCliente();

        //
        //
        BeanHabitacion daoHabi= new BeanHabitacion();
        //
        
        int cliente=Integer.parseInt(request.getParameter("id"));
        int id =Integer.parseInt(request.getParameter("id"));
        int habitacion=Integer.parseInt(request.getParameter("id"));
        String fechaE= request.getParameter("fechaEntada");
        String fechaS= request.getParameter("fechaSalida");

      
        
        Cliente cate =daoCategoria.buscar(cliente);
        Habitacion cate2=daoHabi.buscar(habitacion);
        Reserva libro= new Reserva();
        libro.setIdCliente(cate);
        libro.setIdHabitacion(cate2);
        libro.setIdReserva(id);
        libro.setFechaEntrada(fechaE);
        libro.setFechaSalida(fechaS);
        
if(id >0){
    daoLibro.editar(libro); 
}else{
    daoLibro.insertar(libro);
}
response.sendRedirect("reservaServlet");
    

    }
}


