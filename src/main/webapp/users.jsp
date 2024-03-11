<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
  <%@include file="head.jsp"%>
</head>

<body>
<fmt:setLocale value="pt_BR"/>
<%@include file="cabecalho.jsp"%>

<c:choose>
  <c:when test="${requestScope.ticketatual eq null}">
    <div class="container" style="align-content: center; width: 70%; padding-top: 50px">
      <table class="highlight">
        <thead>
        <tr>
          <th class="s3">Name</th>
          <th class="s3">Email</th>
          <th class="s3">Email</th>

          <th class="right"></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.users}" var="u">
          <tr>
            <td><c:out value="${u.name}"/></td>
            <td><c:out value="${u.email}"/></td>
            <td><c:out value="${u.getTypeUser(u)}"/></td>
            <td class="right">
              <a class="waves-effect waves-light btn blue darken-3" href="editar?id=${p.id}"><i class="material-icons center">edit</i></a>
              <a class="waves-effect waves-light btn red" href="excluir?id=${p.id}"><i class="material-icons center">delete</i></a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

      <div class="row">
        <div class="col s12" style="margin-top: 20px">
          <a class="waves-effect waves-light btn blue darken-3" href="editar?id=0">Novo<i class="material-icons right">add</i></a>
        </div>
      </div>
    </div>
  </c:when>

  <c:when test="${requestScope.useratual ne null}">
    <div class="container" style="align-content: center; width: 70%; padding-top: 50px">
      <form action="salvar" method="POST">
        <div class="row">
          <div class="input-field col s12">
            <input id="id" name="id" type="hidden" value="${useratual.id}">
          </div>

          <div class="input-field col s12">
            <input id="title" name="title" type="text" class="validate" value="${useratual.name}">
            <label for="title">Titulo</label>
          </div>

          <div class="input-field col s12">
            <input id="description" name="description" type="text" class="validate" value="${useratual.email}">
            <label for="description">Descrição</label>
          </div>

          <div class="col s12">
            <label>Tipo de Usuário</label>
            <select class="browser-default" name="type">
              <option value="" disabled>Selecione um tipo por gentileza.</option>
              <option value="ADMIN" ${useratual.userType eq 'ADMIN' ? 'selected' : ''}>ADMIN</option>
              <option value="DEFAULT" ${useratual.userType eq 'DEFAULT' ? 'selected' : ''}>DEFAULT</option>
              <option value="HELPER" ${useratual.userType eq 'HELPER' ? 'selected' : ''}>HELPER</option>
            </select>
            </select>
          </div>
        </div>

        <div class="row">
          <div class="col s12">
            <button class="btn waves-effect waves-light blue darken-3" type="submit" name="salvar">Salvar
              <i class="material-icons right">save</i>
            </button>
            <a class="waves-effect waves-light btn red" href="listar">Cancelar<i class="material-icons right">cancel</i></a>
          </div>
        </div>
      </form>
    </div>
  </c:when>
</c:choose>
</body>
</html>
