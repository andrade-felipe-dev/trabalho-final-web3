<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <c:import url="head.jsp"/>
  <link rel="stylesheet" href="css/login/login.css">
</head>
<body>
<div>
  <form action="/login" method="POST">
    <div class="center-align">
      <img src="assets/logo.png" width="200" height="200">
    </div>
    <div class="input-field col s10">
      <input id="email" name="email" type="email" class="validate">
      <label for="email">E-mail</label>
    </div>
    <div class="input-field col s10">
<%--      <input id="password" name="password" type="password" class="validate">--%>
<%--      <label for="password">Senha</label>--%>
      <a class="right waves-effect waves-teal btn-flat blue-text" href="/registrar">Registre-se</a>
    </div>
    <button class="btn waves-effect waves-light blue darken-3" type="submit" name="action">
      Acessar
    </button>
  </form>
</div>
</body>
</html>