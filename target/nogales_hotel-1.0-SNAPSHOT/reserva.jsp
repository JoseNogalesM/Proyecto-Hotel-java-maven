<%-- 
    Document   : reserva
    Created on : 27 nov. de 2023, 16:42:22
    Author     : nogal
--%>

<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

List<Reserva> libros= (List<Reserva>)request.getAttribute("view");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
           
                <tr>
                    <th>ID</th>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Disponible</th>
                    <th>Categoria</th>
                </tr>
                <%
                for(Reserva item :libros){
                %>
                <tr>
                    <td><%=item.getIdCliente()%></td>
                    <td><%=item.getIdHabitacion()%></td>
                    <td><%=item.getIdReserva() %></td>
                    <td><%=item.getFechaEntrada() %></td>
                    <td><%= item.getFechaSalida() %></td>
                    <td><a href="reservaServlet?action=edit&id=<%= item.getIdReserva()%>">Editar</a></td>
                    <td><a href="reservaServlet?action=delete&id=<%= item.getIdReserva() %>">Eliminar</a></td>

                </tr>
                <%
                    }%>
        </table>
    </body>
</html>
