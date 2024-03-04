<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <c:import url="head.jsp"/>
  <link rel="stylesheet" href="css/login/login.css">
</head>
<body>
<div>
  <form action="/registrar" method="POST">
    <div class="center-align">
      <img src="assets/logo.png" width="200" height="200">
    </div>
    <div class="input-field col s10">
      <input id="name" name="name" type="text" class="validate">
      <label for="name">Nome</label>
    </div>
    <div class="input-field col s10">
      <input id="email" name="email" type="email" class="validate">
      <label for="email">E-mail</label>
    </div>
    <button class="btn waves-effect waves-light blue darken-3" type="submit" name="action">
      Cadastrar
    </button>
  </form>
</div>
</body>
</html>