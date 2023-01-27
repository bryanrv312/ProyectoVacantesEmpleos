<%-- 
    Document   : frmenviarcv
    Created on : 26/12/2020, 06:29:37 PM
    Author     : BRUman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <jsp:include page="header.jsp" />
        <title>Envio de CV</title>    
        <script src="js/script.js"></script>
    </head>

    <body>

        <div class="container">

            <jsp:include page="nav-simple.jsp" />
            
            <br>

            <h4><font color="red">${message}</font></h4>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><b>Enviar CV para vacante: ${vacante.nombre}</b></h3>
                </div>
                
                <div class="panel-body">
                    
                    <form action="solicitud" method="post" enctype="multipart/form-data" onclick="comprueba_extension(this.form, this.form.archivo.value)">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" value="${solicitud.nombre}" required id="nombre" autofocus="">
                        </div>                   
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" value="${solicitud.email}" required id="email">
                        </div>                   
                        <div class="form-group">
                            <label for="telefono">Teléfono</label>
                            <input type="text" class="form-control" name="telefono" value="${solicitud.telefono}" required id="telefono">
                        </div>                   
                        <div class="form-group">
                            <label for="direccio n">Dirección</label>
                            <input type="text" class="form-control" name="direccion" value="${solicitud.direccion}" required id="direccion">
                        </div>                                          
                        <div class="form-group">
                            <label for="archivo">Subir CV</label>
                            <input type="file" required id="archivo" name="archivo" accept="application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/pdf">
                            <p class="help-block">Solo se permiten archivos [ pdf,doc,docx ]</p>
                        </div>             
                        <input type="hidden" value="${vacante.id}" name="idVacante">
                        <button type="submit" class="btn btn-success" >Enviar</button>
                    </form>
                </div>
            </div>

            <jsp:include page="footer.jsp" />

        </div> <!-- /container -->

    </body>
</html>