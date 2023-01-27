
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;


public class UsuarioDao {
    
    DbConnection conn;
    
    public UsuarioDao(DbConnection conn){
        this.conn = conn;
    }
    
    
    public Usuario login(String user, String pass){
        try {
            String sql = "select * from Usuario where useername = ? and password = ? and status = 'activo' limit 1";
            PreparedStatement pst = conn.getConnection().prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet res = pst.executeQuery();
            
            Usuario usu = new Usuario(0);
            
            while(res.next()){       
                usu.setId(res.getInt("id"));
                usu.setNombre(res.getString("nombre"));
                usu.setEmail(res.getString("email"));
                usu.setUsername(res.getString("useername"));
                usu.setPassword(res.getString("password"));
                usu.setPerfil(res.getString("perfil"));
                usu.setStatus(res.getString("status"));                
            }
            return usu;
            
        } catch (SQLException ex) {
            System.out.println("Error en UsuarioDao.login(): " + ex);
            return null;        
        }
    }
        
    

    //PRUEVAS DE METODOS
    
    
    public static void main(String[] args) {
        
        DbConnection conn = new DbConnection();
        UsuarioDao udao = new UsuarioDao(conn);
        Usuario usu = udao.login("bryan", "1234");
        
        System.out.println(usu);
        //System.out.println(usu.getId());
    }
    
    
}
