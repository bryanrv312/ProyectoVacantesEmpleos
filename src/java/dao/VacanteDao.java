
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vacante;

public class VacanteDao {
    
    DbConnection conn;
    
    public VacanteDao(DbConnection conn){
        this.conn = conn;
    }
    
    
    
    public boolean insert(Vacante vacante){      
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//FORMATO PARA LAS FECHAS
        String sql = "insert into vacante values(?,?,?,?,?)";
        
        try {          
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, vacante.getId());
            ps.setString(2,format.format(vacante.getFechaPublicacion()));
            ps.setString(3, vacante.getNombre());
            ps.setString(4, vacante.getDescripcion());
            ps.setString(5, vacante.getDetalle());
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VacanteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    public List<Vacante> getUltimas(){  
        try {         
            String sql = "select * from Vacante order by id desc limit 3";//solo se mostrara los 3 ultimos registros
            PreparedStatement pst = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            ResultSet res = pst.executeQuery();//res almacena los registros de la bd
            
            List<Vacante> list = new LinkedList<>();
            Vacante vac;
            
            while(res.next()){
                vac = new Vacante(res.getInt("id"));
                vac.setFechaPublicacion(res.getDate("fechaPublicacion"));
                vac.setNombre(res.getString("nombre"));
                vac.setDescripcion(res.getString("descripcion"));
                vac.setDetalle(res.getString("detalle"));
                list.add(vac);
            }
            return list;
            
        } catch (SQLException ex) {
            System.out.println("Error VacanteDAO.getUltimas: " + ex.getMessage());
            return null;
        }   
    }
    
    
    public Vacante getById(int idVacante){  
        try {
            String sql = "select * from vacante where id = ? limit 1";
            PreparedStatement pst = conn.getConnection().prepareStatement(sql);
            pst.setInt(1,idVacante);
            ResultSet res = pst.executeQuery();
            
            Vacante vac = null;
            
            while(res.next()){
                vac = new Vacante(idVacante);
                vac.setId(idVacante);
                vac.setNombre(res.getString("nombre"));
                vac.setFechaPublicacion(res.getDate("fechaPublicacion"));
                vac.setDetalle(res.getString("descripcion"));
                vac.setDetalle(res.getString("detalle"));
            }  
            return vac;
            
        } catch (SQLException e) {
            System.out.println("Error en VacanteDao.getById: "+e.getMessage());
            return null;
        }
    }
    
    
    
    public List<Vacante> getAll(){        
        try {       
            String sql = "select * from Vacante order by id desc";//solo se mostrara los todos registros
            PreparedStatement pst = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            ResultSet res = pst.executeQuery();//res almacena los registros de la bd
            
            List<Vacante> list = new LinkedList<>();
            Vacante vac;
            
            while(res.next()){
                vac = new Vacante(res.getInt("id"));
                vac.setFechaPublicacion(res.getDate("fechaPublicacion"));
                vac.setNombre(res.getString("nombre"));
                vac.setDescripcion(res.getString("descripcion"));
                vac.setDetalle(res.getString("detalle"));
                list.add(vac);
            }     
            return list;
            
        } catch (SQLException ex) {
            System.out.println("Error VacanteDAO.getAll: " + ex.getMessage());
            return null;
        }
    }
    
    
    public List<Vacante> getByQuery(String query){
        try {
            String sql = "select * from Vacante where (descripcion like ? or nombre like ?) order by id desc";
            PreparedStatement pst = conn.getConnection().prepareStatement(sql);
            pst.setString(1, "%" + query + "%");
            pst.setString(2, "%" + query + "%");
            ResultSet res = pst.executeQuery();
            
            List<Vacante> lista = new LinkedList<>();
            Vacante vac;
            
            while(res.next()){
                vac = new Vacante(res.getInt("id"));
                vac.setNombre(res.getString("nombre"));
                vac.setFechaPublicacion(res.getDate("fechaPublicacion"));
                vac.setDescripcion(res.getString("descripcion"));
                vac.setDetalle(res.getString("detalle"));
                lista.add(vac);
            }
            return lista;
            
        } catch (SQLException ex) {
            System.out.println("Error en VacanteDao.getByQuery: "+ex);
            return null;
        }
    }
    
    
    
    public int delete(int idVacante){
        try {
            String sql = "delete from Vacante where id = ?";
            PreparedStatement pst = conn.getConnection().prepareStatement(sql);
            pst.setInt(1, idVacante);
            int rows = pst.executeUpdate();
            
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error!, en VacanteDao.delete(): "+ ex.getMessage());
            return 0;
        }
    }
    
    
    /*
    public static void main(String[] args) {
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        
        for(Vacante vac:vdao.getByQuery("casa")){
            System.out.println(vac.getId());
            System.out.println(vac.getNombre());
        }
        
        
    }
    */
    
    
    /*
    public static void main(String[] args) {
        
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        
        for(Vacante v:vdao.getUltimas()){
            
            System.out.println("id: "+v.getId());
            System.out.println("nombre: "+v.getNombre());
        }
        
    }*/
    
    /*
    public static void main(String[] args) {
        DbConnection conn = new DbConnection();
        VacanteDao vdao = new VacanteDao(conn);
        
        Vacante vac = vdao.getByTd(19);
        
        System.out.println(vac.getId());
        System.out.println(vac.getNombre());
    }
    */
}
