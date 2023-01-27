
package model;

import java.util.Date;


public class Vacante {
    
    private int id;
    private Date fechaPublicacion;
    private String nombre;
    private String descripcion;
    private String detalle;

    public Vacante(int id) {
        this.fechaPublicacion = new Date();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    //METODO TOSTRING: para poder el estatus actual de cada una de las instancias del objeto
    @Override
    public String toString() {
        return "Vacante{" + "id=" + id + ", fechaPublicacion=" + fechaPublicacion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", detalle=" + detalle + '}';
    }
    
  /*  
    public static void main(String[] args) {
        
        Vacante va = new Vacante(123);
        System.out.println(va.toString());
    }
    
    
    ]]]]]]]]]*/
    
}
