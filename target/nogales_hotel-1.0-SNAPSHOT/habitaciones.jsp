<%-- 
    Document   : habitaciones
    Created on : 26 nov. de 2023, 13:25:37
    Author     : nogal
--%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Habitacion"%>
<%
    List<Habitacion> lista =(List<Habitacion>)request.getAttribute("habi");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Lista de habitaciones</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 

    </head>
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZxhJfk_0jwPMcJGq9MPbQtBqsJE-8Y4LX1A&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
    HABITACIONES
  </a>
    
</nav>
<br>
<br>
   <table class="table table-striped" width="300"  >
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NRO.HABITACION</th>
      <th scope="col">TIPO DE HABITACION</th>
            <th scope="col">PRECIO $</th>

      <th scope="col">CUPOS</th>
    </tr>
  </thead>
  <%
                for(Habitacion  item :lista){
                
                    
                %>
                <tr>
                    <td><%= item.getIdHabitacion() %></td>
                    <td><%= item.getNumero() %></td>
                    <td><%= item.getTipo() %></td>
                    <td><%= item.getPrecio()%></td>

                    <td><%= item.getDisponible() %></td>
                    
                    <td><a href="registrado.jsp" onclick="return(confirm('Quiere hacer esta reservacion?? '))">Reservar</a></td>
                
              

                </tr>
                <%
                    }%>
            
    
  </tbody>
</table>
                    
            <a href="index.jsp">Volver</a>          
                    
    
</html>
