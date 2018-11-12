<%-- 
    Document   : books-page.jsp
    Created on : 10/11/2018, 19:54:26
    Author     : gabriel gomes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="list-livros">
    <table border="1">
        <c:choose>
            <c:when test="${not empty livros}">
                <tr>
                    <th>Código</th>
                    <th>Título</th>
                    <th>Ano</th>
                </tr>
                <c:forEach var="liv" items="#{lista}" varStatus="seq">
                    <tr>
                        <td>${liv.codigo}</td>
                        <td>${liv.titulo}</td>
                        <td>${liv.ano}</td>
                    </tr>
                </c:forEach>
                <c:otherwise>
                    <tr>
                        <td>
                            Não há registros
                        </td>
                    </tr>
                </c:otherwise>
            </c:when>
        </c:choose>
    </table>
    
</div>