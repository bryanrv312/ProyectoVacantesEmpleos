
package controller;

import dao.DbConnection;
import dao.SolicitudDao;
import dao.VacanteDao;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Solicitud;
import model.Vacante;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;




//solicitud
public class SolicitudController extends HttpServlet {

   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        
        
        
        if(sesion.getAttribute("usuario") == null){
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            
        }else{
            String action = request.getParameter("action");
            
            if(action.equalsIgnoreCase("solicitudes")){
                this.verTodas(request,response);
            }
        }
        
        
    }

    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            Solicitud solicitud = new Solicitud(0);
            DbConnection con = new DbConnection();
            
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            String extension = "";
            String fileName = "";
            String msg = "";
            FileItem uploaded = null;
            
            // Los items obtenidos serán cada uno de los campos del formulario,
            // tanto campos normales como ficheros subidos.
            List items;
            items = upload.parseRequest(request); //tenia q estar con la libreria jar de commons e importar FileUploadException para q no salga error
            
            // Se recorren todos los items, que son de tipo FileItem
            for (Object item : items) {
                uploaded = (FileItem) item;

                // Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el fichero
                // subido donde nos interese
                if (!uploaded.isFormField()) {

                    // asignamos la fecha al nombre del archivo
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
                    Date Ahora = new Date();

                    // Obtenemos la extensión del archivo
                    extension = FilenameUtils.getExtension(uploaded.getName());

                    fileName = format.format(Ahora) + "." + extension;

                } else {
                    // es un campo de formulario, podemos obtener clave y valor
                    String key = uploaded.getFieldName();
                    String valor = uploaded.getString();

                    switch (key) {
                        case "nombre":
                            solicitud.setNombre(valor);
                            break;
                        case "email":
                            solicitud.setEmail(valor);
                            break;
                        case "telefono":
                            solicitud.setTelefono(valor);
                            break;
                        case "direccion":
                            solicitud.setDireccion(valor);
                            break;
                        case "idVacante":
                            VacanteDao vacanteDao = new VacanteDao(con);
                            solicitud.setVacante(vacanteDao.getById(Integer.parseInt(valor)));
                            break;
                    }
                }
            }

            // Validamos la extensión del archivo
            extension = extension.toLowerCase();
            
            switch (extension) {               
                case "pdf":
                    break;
                    
                case "doc":
                    break;
                    
                case "docx":
                    break;
                    
                default:
                    msg = "Solo se permiten archivos de tipo PDF, DOC y DOCX";
                    Vacante vacante = new Vacante(solicitud.getVacante().getId());
                    request.setAttribute("message", msg);
                    request.setAttribute("solicitud", solicitud);
                    request.setAttribute("vacante", vacante);
                    
                    // Enviamos la respuesta y Renderizamos la vista mensaje.jsp
                    request.getRequestDispatcher("/frmenviarcv.jsp").forward(request, response);
                    return;
            }
            
            // Guardamos el fichero en algún sitio
            ServletContext context = request.getServletContext();
            File fichero = new File(context.getRealPath("/") + "uploads/" + fileName);
            
            /*if(!fichero.exists()){//si no existe
                        fichero.mkdirs();//crea la ruta(el directorio) 
                    }*/
            
            // Asignamos el nombre del archivo subido en la BD
            solicitud.setCurriculum(fileName);
            try {
                uploaded.write(fichero);//guardo el cv en el fichero
            } catch (Exception ex) {
                Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error pe papi al escribir el cv en fichero!!"+ex.getMessage());
            }
            
            // Procesamos los datos a guardar
            SolicitudDao solicitudDao = new SolicitudDao(con);
            boolean sstatus = solicitudDao.insert(solicitud);

            // Preparamos un mensaje para el usuario
            if (sstatus) {
                msg = "La solicitud fue guardada correctamente";
            } else {
                msg = "Ocurrió un error. La solicitud no fue guardada";
            }

            con.disconnect();
            //RequestDispatcher rd;
            // Compartimos la variable msg para poder accederla desde la vista con Expression Language
            request.setAttribute("message", msg);
            // Enviamos la respuesta y Renderizamos la vista mensaje.jsp
            request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
            
            
        } catch (FileUploadException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("errror en el servletUpload papi!!"+ex.getMessage());
        }
        
    }

    
//FUNCIONES PARA EL GET
    protected void verTodas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DbConnection con = new DbConnection();
        SolicitudDao sdao = new SolicitudDao(con);
        
        List<Solicitud> lista = sdao.getAll();
       
        request.setAttribute("solicitudes", lista);
        
        request.getRequestDispatcher("/solicitudes.jsp").forward(request, response);
    }
    
}
