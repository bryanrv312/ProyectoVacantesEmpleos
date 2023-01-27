package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class frmvacante_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <title>Departamento de Recursos Humanos - My Company</title>\n");
      out.write("        <!--<script src=\"https://cdn.tinymce.com/4/tinymce.min.js\"></script>-->\n");
      out.write("        <script src=\"tinymce/tinymce.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            tinymce.init({\n");
      out.write("                selector: '#detalle',\n");
      out.write("                plugins: \"textcolor, table\",\n");
      out.write("                /* https://www.tinymce.com/docs/advanced/editor-control-identifiers/#toolbarcontrols */\n");
      out.write("                toolbar: \"styleselect | undo redo | removeformat | bold italic underline | table \\n\\\n");
      out.write("                      aligncenter alignjustify  | bullist numlist outdent indent | link | print | \\n\\\n");
      out.write("                      fontselect fontsizeselect forecolor backcolor\"\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav-admin.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <br>    \n");
      out.write("            \n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3 class=\"panel-title\">Crear Vacante</h3>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    \n");
      out.write("                    <form action=\"vacante\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"nombre\">Nombre</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"nombre\" required id=\"nombre\" value=\"\" placeholder=\"Escriba el nombre la vacante\" autofocus=\"\">\n");
      out.write("                        </div>                   \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"descripcion\">Descripción</label>\n");
      out.write("                            <textarea class=\"form-control\" name=\"descripcion\" id=\"descripcion\" required rows=\"3\" placeholder=\"Escribe una descripción de la vacante\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detalle\">Escriba los detalles</label>\n");
      out.write("                            <textarea id=\"detalle\" name=\"detalle\" rows=\"10\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\" >Guardar</button>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        </div> <!-- /container -->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
