
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
        <%! Integer indice;
            Integer salto;
            Integer nclient;
            String nameClient;
        %>

        <%
            if (nclient == null) {
                nclient = Utils.getAllClientes().size();
            }
            if (request.getParameter("cantidad") != null) {
                salto = Integer.parseInt(request.getParameter("cantidad"));
            }
            if (salto < 0) {
                salto = 10;

            }
            if (request.getParameter("paginacion") == null) {
                indice = 0;
            } else {
                String boton = request.getParameter("paginacion");
                if (boton.equals("primero")) {
                    indice = 0;
                } else if (boton.equals("anterior")) {
                    indice = indice - salto;
                } else if (boton.equals("siguiente")) {
                    indice = indice + salto;
                } else if (boton.equals("ultimo")) {
                    indice = nclient - salto;
                }
            }
            if (indice < 0) {
                indice = 0;
            }
            if (indice >= nclient) {
                indice = nclient - salto;
            }
        %>


        <%
            if (request.getParameter("nameToSearch") == null) {
                Cookie pageClientname = Utils.getCookie(request, "nameClient");
                if (pageClientname != null) {
                    nameClient = pageClientname.getValue();
                } else {
                    nameClient = "No hay valor en la Cookie";
                }

            } else {
                nameClient = request.getParameter("nameToSearch");
                Cookie guardaCookie = new Cookie("nameClient",
                        nameClient);

                guardaCookie.setMaxAge(24 * 60 * 60 * 365);
                guardaCookie.setPath(request.getContextPath());
                response.addCookie(guardaCookie);
            }
        %>

        <h2>EL usuario introducido fue: <%= nameClient%></h2>
        <% ArrayList<Cliente> clien = new ArrayList<Cliente>();
            clien = Utils.getAllClientesFilter(salto, indice);
        %>
        <table class="clientes">
            <tr><th>Nombre</th><th>Poblacion</th><th>Provincia</th></tr>
                    <%for (Cliente cliente : clien) {%>
            <tr><td><%= cliente.getNombre()%> <%= cliente.getApellido()%></td><td><%= cliente.getPoblacion()%></td><td><%= cliente.getProvincia()%></td></tr>
            <%}%>
        </table>
        <form method="post">
            <button type="submit" name="paginacion" value="primero">|<</button>
            <button type="submit" name="paginacion" value="anterior"><</button>
            <button type="submit" name="paginacion" value="siguiente">></button>
            <button type="submit" name="paginacion" value="ultimo">>|</button>
        </form>
    </body>
</html>
