<%-- 
    Document   : admin
    Created on : 09/12/2020, 05:22:19 PM
    Author     : BRUman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/justified-nav.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <div class="container">
            <div class="masthead">
                <h3 class="text-muted">My Company - Administración</h3>
                
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="admin?action=crear">Crear Vacante</a></li>
                        <li><a href="vacante?action=lista">Vacantes</a></li>
                        <li><a href="solicitud?action=solicitudes">Solicitudes</a></li>
                        <li><a href="admin?action=logout">Salir</a></li>
                    </ul>
                </nav>
            </div>
            <br>
            
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Bienvenido</h3>
                </div>
                
                <div class="panel-body">
                    <h2 class="panel-title"><b>Username</b><br> ${usuario.username} <br><br></h2>
                    <h2 class="panel-title"><b>Email</b><br> ${usuario.email} <br><br></h2>
                    <h2 class="panel-title"><b>Perfil</b><br> ${usuario.perfil} <br><br></h2>
                    <h2 class="panel-title"><b>Estatus</b><br> ${usuario.status} <br><br></h2>
                </div>
            </div>
            
            <jsp:include page="footer.jsp" />
            
        </div><%-- fin container--%>
    </body>
    
</html>
