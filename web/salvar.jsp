<%-- 
    Document   : salvar
    Created on : 06/05/2016, 22:49:51
    Author     : Anderson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="p" scope="page" class="bean.Veiculo"/>
<jsp:useBean id="pDao" scope="page" class="dao.VeiculoDao"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:setProperty name="p" property="*"/>


    <c:if test="${pDao.inserirOuAlterar(p)}">
        Registro Salvo com Sucesso!!!
    </c:if>

    <a href="index.jsp">Voltar</a>    </body>
</html>
