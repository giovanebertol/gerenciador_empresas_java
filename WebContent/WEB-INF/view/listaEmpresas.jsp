 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>

	
  Usuario Logado: ${usuarioLogado.login }
   Lista de empresas2: <br />
	
	<p>Usuário Logado: "${usuarioLogado.login}"</p>
    <ul>
        <c:forEach items="${empresas}" var="empresa">
			<li>
			    ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" />
			    <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
			    <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
			</li>
        </c:forEach>
    </ul>

</body>
</html>