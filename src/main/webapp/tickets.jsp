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
          <th class="s3">Status</th>
          <th class="s3">Titulo</th>
          <th class="s3">Descrição</th>
          <th class="s3">Dias para o término</th>
          <th class="s3">Tema</th>
          <th class="s3">Criado por</th>
          <th class="s3">Responsável</th>
          <th class="right"></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.tickets}" var="p">
          <tr>
            <td><c:out value="${p.status}"/></td>
            <td><c:out value="${p.title}"/></td>
            <td><c:out value="${p.description}"/></td>
            <td> <fmt:formatDate value="${p.endDate}" pattern="dd/MM/yyyy"/></td>
            <td><c:out value="${p.theme.name}"/></td>
            <td><c:out value="${p.createdBy.name}"/></td>
            <td><c:out value="${p.responsible.name}"/></td>
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

  <c:when test="${requestScope.ticketatual ne null}">
    <div class="container" style="align-content: center; width: 70%; padding-top: 50px">
      <form action="salvar" method="POST">
        <div class="row">
          <div class="input-field col s12">
            <input id="id" name="id" type="hidden" value="${ticketatual.id}">
          </div>

          <div class="input-field col s12">
            <input id="title" name="title" type="text" class="validate" value="${ticketatual.title}">
            <label for="title">Titulo</label>
          </div>
          <div class="input-field col s12">
            <input id="description" name="description" type="text" class="validate" value="${ticketatual.description}">
            <label for="description">Descrição</label>
          </div>

          <div class="col s12">
            <label>Temas</label>
            <select class="browser-default" name="theme">
              <option value="" disabled selected>Selecione um Tema Por gentileza.</option>
              <c:forEach items="${requestScope.themes}" var="theme">
                <option value="${theme.id}" <c:if test="${ticketatual.theme.id eq theme.id}">selected</c:if>> <c:out value="${theme.name} - Prazo ${theme.endDateWithDays} dias"></c:out></option>
              </c:forEach>
            </select>
          </div>

          <c:if test="${cookie.type.getValue() == 'ADMIN' && ticketatual.id != 0}">
            <div class="input-field col s12">
              <input type="text" id="newDateTicket" class="datepicker" name="newDateTicket" value="${ticketatual.endDate}">
              <label for="newDateTicket">Previsão de dias para finalizar o ticket</label>
            </div>
          </c:if>

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
