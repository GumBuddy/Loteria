<%--
  Created by IntelliJ IDEA.
  User: KAORD
  Date: 01/09/2019
  Time: 02:16 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
</head>
<body>
Bienvenido al Registro individual del Sistema
<form method="post" action="/Altas">
    Primer Nombre:
    <input type="text" name="Nombres">
    Apellido Paterno:
    <input type="text" name="Apellido_P">
    Apellido Materno:
    <input type="text" name="Apellido_M">
    Sexo:
    <input type="text" name="Edad">
    <button type='submit' class='btn btn-success'>Registrar</button>
</form>
</body>
</html>
