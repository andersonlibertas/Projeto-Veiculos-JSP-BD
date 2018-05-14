<%-- 
    Document   : excluirsalvar
    Created on : 12/05/2016, 20:07:55
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="p" scope="page" class="bean.Veiculo"/>
<jsp:useBean id="pDao" scope="page" class="dao.VeiculoDao"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Excluir</h1>

        <jsp:setProperty name="p" property="*"/>
        <c:if test="${pDao.excluir(p)}">
            REGISTRO EXCLUIDO COM SUCESSO!
        </c:if>
        <a href="index.jsp">Voltar</a>


    </body>
</html>
