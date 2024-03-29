<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url	value="/css/materialize.min.css" var="materialcss"/>
<c:url  value="/js/materialize.js" var = "materialjs"/>
<c:url  value="/js/functions.js" var = "functionsjs"/>
<c:url  value="https://code.jquery.com/jquery-1.9.1.js" var = "jquery"/>
<c:url	value="/css/estilo.css" var="customcss"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="${materialcss}"  media="screen,projection"/>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Help Desk</title>
<link type="text/css" rel="stylesheet" href="${customcss}"/>
<script src="${jquery}"></script>
<script src="${materialjs}"></script>
<script src="${customjs}"></script>
<script src="${functionsjs}"></script>