/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DbConnection;
import dao.UsuarioDao;
import dao.VacanteDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;


//admin
public class AdminController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String msg = ""; 
        
        HttpSession sesion = request.getSession();
        
        
        switch(action){
            
            case "login":
                if(sesion.getAttribute("usuario") == null){
                    msg = "acceso denegado";
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("/admin.jsp").forward(request, response); 
                }
                break;
            
            case "logout":
                sesion.invalidate();//destruye la sesion y a sus atributos
                response.sendRedirect(request.getContextPath()+ "/homepage");
                break;
                
            case "crear":
                if(sesion.getAttribute("usuario") == null){
                    msg = "acceso denegado";
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("/frmvacante.jsp").forward(request, response);
                }
                break;
                
            case "eliminar":
                if(sesion.getAttribute("usuario") == null){
                    msg = "acceso denegado";
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }else{
                    this.eliminarVacante(request, response);
                }
                break;
                
            default:
                break;
        }
        
        
        /*
        if(action.equalsIgnoreCase("login")){
            if(sesion.getAttribute("usuario") == null){
                msg = "acceso denegado";
                request.setAttribute("message", msg);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/admin.jsp").forward(request, response); 
            }
            
        }else if(action.equalsIgnoreCase("logout")){
            sesion.invalidate();//destruye la sesion y a sus atributos
            response.sendRedirect(request.getContextPath()+ "/homepage");
            
        }else if(action.equalsIgnoreCase("crear")){
            if(sesion.getAttribute("usuario") == null){
                msg = "acceso denegado";
                request.setAttribute("message", msg);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/frmvacante.jsp").forward(request, response);
            }
            
        }else if(action.equalsIgnoreCase("eliminar")){
            if(sesion.getAttribute("usuario") == null){
                msg = "acceso denegado";
                request.setAttribute("message", msg);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                this.eliminarVacante(request, response);
            }
        }
        */
    }
    
    
    //metodos
    
    private void eliminarVacante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idVacanteParam = Integer.parseInt(request.getParameter("idVacante"));
        
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        String msg = "";
        int rpta = vdao.delete(idVacanteParam);
        
        if(rpta == 1){
            msg = "Vacante eliminada correctamente.";
        }else{
            msg = "NO se pudo eliminar la Vacante";
        }
        
        conn.disconnect();
        request.setAttribute("message", msg);
        request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String msg = "";
        
        //recuperamos una instancia del objeto HttpSession
        HttpSession sesion = request.getSession();
        
        DbConnection conn = new DbConnection();
        UsuarioDao udao = new UsuarioDao(conn);
        
        //verificamos en la bd si el usuario es correcto (gracias al toString)
        Usuario usu = udao.login(user, pass);
        conn.disconnect();
        
        RequestDispatcher rd;
        
        if(usu.getId() > 0){
            sesion.setAttribute("usuario", usu);
            rd = request.getRequestDispatcher("/admin.jsp");
            rd.forward(request, response);
            //request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }else{
            msg = "Usuario y/o Password incorrectos";
            request.setAttribute("message", msg);
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
            //request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
    }

   
}
