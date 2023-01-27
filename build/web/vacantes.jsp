<%-- 
    Document   : vacantes
    Created on : 08/12/2020, 12:10:59 PM
    Author     : BRUman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <jsp:include page="header.jsp" />
        <title>Lista de todas las vacantes</title>
    </head>

    <body>

        <div class="container">

            <jsp:include page="nav-simple.jsp" />
            
            
            <form method ="post" action="buscar" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
                </div>        
                <button type="submit" class="btn btn-success">Buscar</button>
            </form>
            
            
            <br><br><br>

            
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><b>Lista de Vacantes</b></h3>
                </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        
                        <thead>
                            <tr>
                                <th class="left">ID</th>
                                <th>Vacante</th>
                                <th>Publicado</th>                
                                <th></th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            
                            <c:forEach items="${listaVacantes}" var="vac" varStatus="status">
                                <tr>
                                    <td class="left">${vac.id}</td>
                                    <td>${vac.nombre}</td>
                                    <td>${vac.fechaPublicacion}</td>
                                    <td><a class="btn btn-default" href="vacante?action=ver&id=${vac.id}" role="button">Ver Detalles</a>                
                                        <c:if test="${usuario.id > 0}">
                                            <a class="btn btn-default" href="admin?action=eliminar&idVacante=${vac.id}" role="button">Eliminar</a> 
                                        </c:if>
                                    </td>  
                                </tr>
                            </c:forEach>      

                        </tbody>           
                    </table>
                </div>
            </div>

            <jsp:include page="footer.jsp" />

        </div> <!-- /container -->

    </body>
</html>


