/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DbConnection;
import dao.VacanteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vacante;



//buscar
public class BusquedaController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String q = request.getParameter("query");
        
        List<Vacante> lista = null;
        
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        
        lista = vdao.getByQuery(q);
        
        request.setAttribute("listaVacantes", lista);
        
        conn.disconnect();
        
        request.getRequestDispatcher("/vacantes.jsp").forward(request, response);
        
        
    }

   
}
