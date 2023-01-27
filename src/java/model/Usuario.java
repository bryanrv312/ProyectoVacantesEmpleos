
package model;


public class Usuario {
    
    private int id;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private String perfil;
    private String status = "activo";

    /*
    public Usuario() {
    }
    */
    

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username + ", password=" + password + ", perfil=" + perfil + ", status=" + status + '}';
    }
    
    /*
    public static void main(String[] args) {
        Usuario usu = new Usuario();
        System.out.println(usu.toString());
    }*/
    
    
}
