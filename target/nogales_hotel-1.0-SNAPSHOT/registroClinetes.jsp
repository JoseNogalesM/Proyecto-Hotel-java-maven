<%-- 
    Document   : registroClinetes
    Created on : 26 nov. de 2023, 17:37:32
    Author     : nogal
--%>
<%@page import="com.emergentes.entidades.Cliente"%>
<%
    Cliente cli = (Cliente) request.getAttribute("clientes");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Clientes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 

    </head>
    <body>


        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="data:image/png;base64,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" width="30" height="30" > REGISTRO DE CLIENTES
            </a>
        </nav>


        <form action=" clientesServlet " method="post" class="px-4 py-4">

            <input type="hidden"  name="idCliente" value="<%= cli.getIdCliente()%>">

            <div class="form-group">
                <label for="exampleInputPassword1">Nombre:</label>
                <input type="text" name="nombre" value="<%= cli.getNombre()%>" class="form-control" id="exampleInputPassword1" placeholder="Nombre Completo">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Correo:</label>
                <input type="text" name="correo" value="<%= cli.getCorreo()%>" class="form-control" id="exampleInputPassword1" placeholder="Correo electronico">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Telefono:</label>
                <input type="text" name="telefono" value="<%= cli.getTelefono()%>" class="form-control" id="exampleInputPassword1" placeholder="Telefono">
            </div>
            <button type="submit" class="btn btn-primary">Enviar datos</button>
            <a href="index.jsp">Regresar</a>
        </form>
    </body>
</html>
