
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import model.Solicitud;


public class SolicitudDao {
    
    
    DbConnection con;

    public SolicitudDao(DbConnection con) {
        this.con = con;
    }
    
    
    public boolean insert(Solicitud sol){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "insert into solicitud values (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, sol.getId());
            ps.setString(2, sdf.format(sol.getFecha()));
            ps.setString(3, sol.getNombre());
            ps.setString(4, sol.getEmail());
            ps.setString(5, sol.getTelefono());
            ps.setString(6, sol.getDireccion());
            ps.setInt(7, sol.getVacante().getId());
            ps.setString(8, sol.getCurriculum());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error en SolicitudDao.insert(): "+e.getMessage());
            return false;
        }
}
    
    
    public List<Solicitud> getAll(){
        
        try {
            String sql = "select * from Solicitud order by id desc";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            
            List<Solicitud> lista = new LinkedList<>();
            Solicitud sol;
            
            while (res.next()) {
                sol = new Solicitud(res.getInt("id"));
                sol.setFecha(res.getDate("fecha"));
                sol.setNombre(res.getString("nombre"));
                sol.setEmail(res.getString("email"));
                sol.setTelefono(res.getString("telefono"));
                sol.setDireccion(res.getString("direccion"));
                
                DbConnection conn = new DbConnection();
                VacanteDao vdao = new VacanteDao(conn);
                sol.setVacante(vdao.getById(res.getInt("vacante")));
                
                sol.setCurriculum(res.getString("curriculum"));
                
                lista.add(sol);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println("Error..! VacanteDao.getAll: " + e.getMessage());
            return null;
        }
    }
    
    
    public static void main(String[] args) {
        
        DbConnection con = new DbConnection();
        SolicitudDao sdao = new SolicitudDao(con);
        
        
        for(Solicitud sol:sdao.getAll()){
            
            System.out.println(sol.getEmail());
        }
        
    }
    
}
