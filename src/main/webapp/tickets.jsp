<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
  <head>
    <%@include file="head.jsp"%>
  </head>

  <body>
    <fmt:setLocale value="pt_BR"/>
    <%@include file="cabecalho.jsp"%>
      <c:if test="${requestScope.ticketAtual eq null}">
        <div class="container" style="align-content: center; width: 70%; padding-top: 50px">
          <div class="row">
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
                    <td><c:out value="${p.status}"></c:out></td>
                    <td><c:out value="${p.title}"></c:out></td>
                    <td><c:out value="${p.description}"></c:out></td>
                    <td><c:out value="${p.endDateWithDays}"></c:out></td>
                    <td><c:out value="${p.theme}"></c:out></td>
                    <td><c:out value="${p.createdBy}"></c:out></td>
                    <td><c:out value="${p.responsible}"></c:out></td>
                    <td class="right">
                      <a class="waves-effect waves-light btn blue darken-3" href="editar?id=${p.id}"><i class="material-icons center">edit</i></a>
                      <a class="waves-effect waves-light btn red" href="excluir?id=${p.id}"><i class="material-icons center">delete</i></a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </c:if>

      <c:if test="${requestScope.ticketAtual ne null}" >
        <c:set var="t" value="${requestScope.ticketAtual}"/>
        <div class="container" style="align-content: center; width: 70%; padding-top: 50px">
          <form action="salvar" method="POST">
            <div class="row">

              <div class="input-field col s12">
                <input id="id" name="id" type="hidden" value="${t.id}">
              </div>

              <div class="input-field col s12">
                <input id="id_created_by" name="id" type="hidden" value="${t.createdBy.id}">
              </div>

              <div class="input-field col s12">
                <input id="name" name="name" type="text" class="validate" value="${t.title}">
                <label for="name">Titulo</label>
              </div>

              <div class="input-field col s12">
                <input id="description" name="description" type="text" class="validate" value="${p.description}">
                <label for="description">Descrição</label>
              </div>

              <select name="curso">
                <option value="0" selected>Nenhum</option>
                <c:forEach items="${requestScope.themes}" var="theme">
                  <option value="${theme.id}" <c:if test="${t.theme.id eq theme.id}">selected</c:if>> <c:out value="${theme.name}"></c:out></option>
                </c:forEach>
              </select>
              <label>Temas</label>
            </div>
            <div class="row">
              <div class="col s12">
                <button class="btn waves-effect waves-light blue darken-3" type="submit" name="action">Salvar
                  <i class="material-icons right">save</i>
                </button>
                <a class="waves-effect waves-light btn red" href="listar">Cancelar<i class="material-icons right">cancel</i></a>
              </div>
            </div>
          </form>
        </div>
      </c:if>
  </body>
</html>
