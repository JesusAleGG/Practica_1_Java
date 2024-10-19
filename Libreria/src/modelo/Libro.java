package modelo;

public class Libro {
                            // ATRIBUTO DE LA CLASE LIBRO // 
private Autor autor;
   private String titulo =" ";
   private int ano_pub = 0;
   private int paginas =0;
   private int lecture_time =1;
   private double precio =0.0;
   
    public Libro(){
        
        this.autor = new Autor();
        this.titulo = "No ha sido establecido";
        this.ano_pub= 0;
        this.lecture_time = 1;
        this.precio = 0.0;
        this.paginas = 0;
    }

    public Libro(String nombre_Autor, String apellidosAutor, String titulo, int ano_pub,int lecture_time, double precio , Boolean premBoolean, int paginas){
        this.autor = new Autor(nombre_Autor,apellidosAutor,premBoolean);
        this.titulo = titulo;
        this.ano_pub= ano_pub;
        this.lecture_time = lecture_time;
        this.precio = precio;
        this.paginas = paginas;
       
    }
///////////////// METODODS /////////////////////////////

    public int tlm (){
        int result = 0;
        result = this.paginas/this.lecture_time;
        if(this.lecture_time == 0){
            return 0;
        }
        return result;
    }
    
///////////////// GETTERS Y SETTERS ////////////////////

    public void setAutor(String nombre, String apellidos, boolean premBoolean) {
        this.autor.setNombre(nombre);
        this.autor.setApellidos(apellidos);
        this.autor.setPrePlaneta(premBoolean);
    }

    public String getAutorNombre() {
        return this.autor.getNombre();
    }
    public String getAutorApellidos() {
        return this.autor.getApellidos();
    }
    public boolean getAutorBoolean() {
        return this.autor.getPrePlaneta();
    }
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno_pub() {
        return ano_pub;
    }

    public void setAno_pub(int ano_pub) {
        this.ano_pub = ano_pub;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getLecture_time() {
        return lecture_time;
    }

    public void setLecture_time(int lecture_time) {
        this.lecture_time = lecture_time;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
