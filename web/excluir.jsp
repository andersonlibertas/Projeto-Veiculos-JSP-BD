<%-- 
    Document   : excluir
    Created on : 16/05/2016, 19:58:44
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="p" class="bean.Veiculo" scope="page"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:setProperty name="p" property="*"/>
        
        Confirma exclusão?
        </br>
        <a href="excluirsalvar.jsp?idveiculo=${p.idveiculo}">Sim</a>
        <a href="index.jsp">Não</a>
    </body>
</html>
