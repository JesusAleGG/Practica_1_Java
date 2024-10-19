package modelo;

public class Autor {
    
    private String nombre;
    private String apellidos;   // ATRIBUTOS AUTOR ///
    private Boolean PrePlaneta;

    public Autor(){ // CONSTRUCTORES //
        this.nombre = "Joe";
        this.apellidos = "Nobody";
        this.PrePlaneta = false;
    }

    public Autor(String nombre, String apellidos, Boolean booleano){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.PrePlaneta = booleano;
    }
//////////////////////////////////////////////////////////////////

// GETTERS y SETTERS DE LA CLASE AUTOR

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Boolean getPrePlaneta() {
        return PrePlaneta;
    }

    public void setPrePlaneta(Boolean prePlaneta) {
        PrePlaneta = prePlaneta;
    }
    
    
    
}
