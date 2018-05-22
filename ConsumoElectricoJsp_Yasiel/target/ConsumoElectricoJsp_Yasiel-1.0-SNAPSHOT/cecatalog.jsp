
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.consumoelectricojsp_yasiel.Cliente"%>
<%@page import="com.mycompany.consumoelectricojsp_yasiel.Utils"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>EL usuario introducido fue: <%= request.getParameter("nameToSearch")%></h2>
        <% ArrayList<Cliente> clien = new ArrayList<Cliente>();
            clien = Utils.getAllClientes();
        %>
        <table class="clientes">
            <tr><th>Nombre</th><th>Poblacion</th><th>Provincia</th></tr>
            <%for (Cliente cliente : clien) {%>
            <tr><td><%= cliente.getNombre()%> <%= cliente.getApellido()%></td><td><%= cliente.getPoblacion()%></td><td><%= cliente.getProvincia()%></td></tr>
            <%}%>
        </table>
    </body>
</html>
