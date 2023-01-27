
package model;

import java.util.Date;


public class Solicitud {
    
    private int id;
    private Date fecha;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private Vacante vacante;
    private String curriculum;

    public Solicitud(int id) {
        this.id = id;
        this.fecha = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Vacante getVacante() {
        return vacante;
    }

    public void setVacante(Vacante vacante) {
        this.vacante = vacante;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }
    
    

    @Override
    public String toString() {
        return "Solicitud{" + "id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + 
                              ", email=" + email + ", telefono=" + telefono + 
                              ", direccion=" + direccion + ", vacante=" + vacante + 
                              ", curriculum=" + curriculum + '}';
    }
     
    
    
}
