<%-- 
    Document   : index
    Created on : 06/05/2016, 22:49:23
    Author     : Anderson
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="pDao" class="dao.VeiculoDao" scope="page"/>
<jsp:useBean id="p" class="bean.Veiculo" scope="page"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="formulario.jsp">Cadastrar</a>
        <table border="1">
            <th>Id</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ano</th> 
            <th>Placa</th>
                <c:forEach var="p" items="${pDao.listar()}">

                <tr>                   
                    <td>  ${p.getIdveiculo()} </td>
                    <td>  ${p.getMarca()} </td>
                    <td>  ${p.getModelo()} </td>
                    <td>  ${p.getAno()} </td>
                    <td>  ${p.getPlaca()} </td>
                    <td> <a href="formulario.jsp?idveiculo=${p.getIdveiculo()}"><img width=35px weigth=35px src="img/1.jpg"></a></td>
                    <td> <a href="excluir.jsp?idveiculo=${p.getIdveiculo()}"><img width=35px weigth=35px src="img/2.jpg"></a></td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
