<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <title>Departamento de Recursos Humanos - My Company</title>
        <!--<script src="https://cdn.tinymce.com/4/tinymce.min.js"></script>-->
        <script src="tinymce/tinymce.min.js"></script>

        <script>

            tinymce.init({
                selector: '#detalle',
                plugins: "textcolor, table",
                /* https://www.tinymce.com/docs/advanced/editor-control-identifiers/#toolbarcontrols */
                toolbar: "styleselect | undo redo | removeformat | bold italic underline | table \n\
                      aligncenter alignjustify  | bullist numlist outdent indent | link | print | \n\
                      fontselect fontsizeselect forecolor backcolor"
            });

        </script>
    </head>

    <body>

        <div class="container">
            <jsp:include page="nav-admin.jsp" />

            <br>    
            
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Crear Vacante</h3>
                </div>
                
                <div class="panel-body">
                    
                    <form action="vacante" method="post">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" required id="nombre" value="" placeholder="Escriba el nombre la vacante" autofocus="">
                        </div>                   
                        <div class="form-group">
                            <label for="descripcion">Descripción</label>
                            <textarea class="form-control" name="descripcion" id="descripcion" required rows="3" placeholder="Escribe una descripción de la vacante"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="detalle">Escriba los detalles</label>
                            <textarea id="detalle" name="detalle" rows="10"></textarea>
                        </div>
                        <button type="submit" class="btn btn-default" >Guardar</button>
                    </form>
                    
                </div>
            </div>

            <jsp:include page="footer.jsp" />
        </div> <!-- /container -->
    </body>
</html>
