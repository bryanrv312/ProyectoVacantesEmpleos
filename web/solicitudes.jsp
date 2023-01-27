<%-- 
    Document   : solicitudes
    Created on : 03/01/2021, 03:39:08 PM
    Author     : BRUman
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="header.jsp" />
        <title>Lista de todas las Solicitudes</title>
    </head>

    <body>

        <div class="container">

            <jsp:include page="nav-admin.jsp" />
            <br>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><b>Lista de solicitudes recibidas</b></h3>
                </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th class="left">Fecha</th>
                                <th>Nombre</th>
                                <th>Email</th>                
                                <th>Teléfono</th>
                                <th>Dirección</th>
                                <th>Aplicó para</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${solicitudes}" var="solicitud" varStatus="status">
                                <tr>
                                    <td class="left">${solicitud.fecha}</td>
                                    <td>${solicitud.nombre}</td>
                                    <td>${solicitud.email}</td>
                                    <td>${solicitud.telefono}</td>
                                    <td>${solicitud.direccion}</td>
                                    <td>${solicitud.vacante.nombre}</td>
                                    <td>
                            <center>   
                                <!-- Mostramos un link para el archivo del CV que subio el usuario. El nombre del archivo lo tenemos
                                guadado en el campo archivo de la tabla solicitud y estan almacenados en la carpeta uploads en nuestro
                                directorio raiz de nuestra aplicacion.
                                -->
                                <a href="uploads/${solicitud.curriculum}" target="_blank">
                                    <img src="images/download.png" title="Descargar Curriculum Vitae">
                                </a>
                                &nbsp;&nbsp;&nbsp;
                                <!-- Mostramos un link para que el administrador le pueda enviar un correo electronico al usuario que
                                envio su CV. Mandamos el parametro email del usuario, al formulario donde se redactara el email.
                                -->
                                <a href="solicitud?action=responder&email=${solicitud.email}">
                                    <img src="images/mail.png" title="Enviar correo electrónico.">
                                </a>
                            </center>  
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
