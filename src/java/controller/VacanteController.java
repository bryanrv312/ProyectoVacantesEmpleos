
package controller;

import dao.DbConnection;
import dao.VacanteDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vacante;

//vacante
public class VacanteController extends HttpServlet {
    
    
    //METODO GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action.equalsIgnoreCase("ver")){
            this.verDetalle(request,response);//guarda la solicitud 
            
        }else if(action.equalsIgnoreCase("lista")){
            this.verTodas(request,response); 
            
        }else if(action.equalsIgnoreCase("enviarcv")){
            this.enviarCV(request,response);
        }   
    }
    
    
    
    
    
    //METODO POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreParam = request.getParameter("nombre");
        String descripcionparam = request.getParameter("descripcion");
        String detalleparam = request.getParameter("detalle");
        
        Vacante vac = new Vacante(0);
        vac.setNombre(nombreParam);
        vac.setDescripcion(descripcionparam);
        vac.setDetalle(detalleparam);
        
        System.out.println(vac);
        
        //procesamos los datos, guardamos en la BD
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        
        boolean status = vdao.insert(vac); //aca se utiliza la funcion insert      
        String msg = "";
        
        if (status) {
            msg = "La vacante fue guardada correctamente :D !!";
        }else{
            msg = "ERROR!!, La vacante NO se guardo :c";
        }
        
        conn.disconnect();
        request.setAttribute("message", msg);
        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        
    }
    
    
    
    
    protected void verDetalle(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        int idVacante = Integer.parseInt(request.getParameter("id"));
        
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        Vacante vac = vdao.getById(idVacante);
        conn.disconnect();
        
        //compartimos el objeto vac para poder accederla desde la vista con JSTL
        request.setAttribute("vacante", vac);
        
        //redireccionamos
        request.getRequestDispatcher("/detalle.jsp").forward(request, response);
    }
    
    
    protected void verTodas(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        List<Vacante> lista = vdao.getAll();
        conn.disconnect();
        
        request.setAttribute("listaVacantes", lista);       
        request.getRequestDispatcher("/vacantes.jsp").forward(request, response);    
        
    }
    
    
    private void enviarCV(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        int idVacante = Integer.parseInt(request.getParameter("id"));
        
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        Vacante vac = vdao.getById(idVacante);
        conn.disconnect();
        
        request.setAttribute("vacante", vac);     
        request.getRequestDispatcher("/frmenviarcv.jsp").forward(request, response);
    }

    

}
