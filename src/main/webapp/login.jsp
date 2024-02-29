<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <script>
        <%@include file="js/functions.js" %>
    </script>
</head>
<body>
<h1>Login</h1>

<form action="LoginServlet" method="post">
    <div class="row">
        <div class="input-field col s12">
            <input type="email" id="email" name="email" required class="validate">
            <label for="email">Email</label>
        </div>
    </div>

    <div class="row">
        <div class="input-field col s12">
            <input type="password" id="senha" name="senha" required class="validate">
            <label for="senha">Senha</label>
        </div>
    </div>

    <div class="row">
        <div class="col s6">
            <a href="registrar.jsp" class="waves-effect waves-light btn">Registre-se aqui</a>
        </div>
        <div class="col s6">
            <button type="submit" class="waves-effect waves-light btn blue">Acessar</button>
        </div>
    </div>
</form>
</body>
</html>
