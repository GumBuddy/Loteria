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
<form method="post" action="Registro">
    <h3> Primer Nombre:</h3>
    <input type="text" name="Nombres">
    <h3> Apellido Paterno:</h3>
    <input type="text" name="Apellido_P">
    <h3> Apellido Materno:</h3>
    <input type="text" name="Apellido_M">
    <h3>Sexo:</h3>
    <input type="text" name="Edad">
    <h3>Grupo:</h3>
    <h6>**En caso de no tener un grupo Puede dejar vacio el espacio, esto no afectara con su registro en el
        sistema**</h6>
    <input type="text" name="Grupo">
    <h3>¿Es universitario?:</h3>
    <input type="text" name="tipo">
    <h3>Adscripcion:</h3>
    <input type="text" name="adscripcion">
    <h3>Adscripcion:</h3>
    <input type=text name="Correo">
    <h3>Adscripcion:</h3>
    <input type="text" name="Direccion">
    <h3>Adscripcion:</h3>
    <input type="text" name="Celular">

    <button type='submit' class='btn btn-success'>Registrar</button>
</form>
<button type='submit' class='btn btn-success' onclick="location.href='index.jsp';">Cancelar</button>

</body>
</html>
