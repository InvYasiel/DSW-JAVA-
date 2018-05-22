
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="loginBean" class="es.cifpcm.aut04_03.Login" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <jsp:getProperty name="loginBean" property="username"/></h1>
    </body>
</html>