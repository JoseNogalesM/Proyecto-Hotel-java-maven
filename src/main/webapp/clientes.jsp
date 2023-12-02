<%@page import="com.emergentes.entidades.Cliente"%>
<%@page import="java.util.List"%>
<%
    List<Cliente> cliente = (List<Cliente>) request.getAttribute("ver");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 

    </head>
    <body>
     
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="data:image/png;base64,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" width="30" height="30" class="d-inline-block align-top" alt="">
    Listado de Clientes
  </a>
</nav>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nombre</th>
      <th scope="col">Correo</th>
      <th scope="col">Telefono</th>
    </tr>
  </thead>
  <%
                        for (Cliente item : cliente) {
            %>
            <tr>
                <td><%=item.getIdCliente()%></td>
                <td><%=item.getNombre()%></td>
                <td><%=item.getCorreo()%></td>
                <td><%=item.getTelefono()%></td>
                  <td><a href="clientesServlet?action=edit&id=<%=item.getIdCliente()%>">Editar</a></td>
                  <td><a href="clientesServlet?action=delete&id=<%=item.getIdCliente()%>">Eliminar</a></td>

            </tr>
            <%
                }
            %>
  
  </tbody>
</table>



    </body>
</html>
