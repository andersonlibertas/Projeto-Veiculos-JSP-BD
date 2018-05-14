<%-- 
    Document   : form2
    Created on : 19/05/2016, 11:57:40
    Author     : Anderson
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="bean.Marca" scope="page"/>
<jsp:useBean id="mDao" class="dao.MarcaDao" scope="page"/>
<jsp:useBean id="vDao" class="dao.VeiculoDao" scope="page"/>
<jsp:useBean id="v" class="bean.Veiculo" scope="page"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:setProperty name="m" property="*"/>
        <jsp:setProperty name="v" property="*"/>

        <h1>Formulário de Cadastro</h1>
        ${mDao.consultar(m)}
        ${m.marca}
        <form action="salvar.jsp" method="post">
            ID:<input type="text" name="idveiculo" value="${v.idveiculo}">

            <br/>
            Modelo:
            <input type="text" name="modelo" value="${v.modelo}"/>

            </br>
            Placa:
            <input type="text" name="placa" value="${v.placa}"/>
            <br/>
            Ano:
            <input type="text" name="ano" value="${v.ano}"/>
            <br/>


            <select name="marca">    
                <c:forEach var="m" items="${mDao.listar()}">    
                    <option value="${m.marca}">${m.marca}</option>    
                </c:forEach>    
            </select>

            <input type="submit" value="Salvar"/>
            


        </select>
    </form>

</body>
</html>

