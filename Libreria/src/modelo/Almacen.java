package modelo;

public class Almacen {

    private int tam = 0;
    private Libro[] book; //= new Libro[tam]; // crea un array de referencias a la clase Libro = al no estar inicializadas estarán a NULL
    static private int librosCreados = 0; // ATRIBUTO ESTÁTICO QUE NOS DIRÁ CUANTOS LIBROS HA CREADO EL USUARIO

    // CONSTRUCTORES                //////////////////////////////////////////////////////////////////
    public Almacen (){
        this.book = new Libro[tam];

        int i = 0;
        
        for(i=0; i< this.tam ; i++){ // crea libros sin idenficacion en la hilera del almacen
            this.book[i] = new Libro();
        }
    }
    public Almacen (int tam){
        this.tam = tam;
        this.book = new Libro[tam];

        //int i = 0;
        
        //for(i=0; i< this.tam ; i++){ // crea libros sin idenficacion en la hilera del almacen
          //  this.book[i] = new Libro();
        //}
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    // GETTERS Y SETTERS /////////////// NOS PERMITIRÁN TAMBIÉN OBTENER ATRIBUTOS DE LAS CLASES LIBRO Y AUTOR

    public void setBook(int tam) {
        this.tam = tam;

    }
    public Libro getBook(int i) {
        return this.book[i];
    }
    public Libro[] getLibros() {
        return this.book;
    }
   
    public void setTitulo(String titulo, int nLibro){
        this.book[nLibro].setTitulo(titulo);
    }
    public String getTitulo(int nLibro){
        return this.book[nLibro].getTitulo();
    }

    public void setPaginas(int paginas, int nLibro){
        this.book[nLibro].setPaginas(paginas);
    }
    public int getPaginas(int nLibro){
        return this.book[nLibro].getPaginas();
    }

    public void setPrecio(double precio, int nLibro){
        this.book[nLibro].setPrecio(precio);;
    }
    public double getPrecio(int nLibro){
        return this.book[nLibro].getPrecio();
    }

    public void setAno_pub(int Ano, int nLibro){
        this.book[nLibro].setAno_pub(Ano);
    }
    public int getAno_pub(int nLibro){
        return this.book[nLibro].getAno_pub();
    }

    public void setAutor(String nombre, String apellidos, boolean premBoolean,int nLibros){
        this.book[nLibros].setAutor(nombre, apellidos, premBoolean);
    }

    public String getNombreAutor(int nLibros){
        return this.book[nLibros].getAutorNombre();
    }
    public String getApellidosAutor(int nLibros){
        return this.book[nLibros].getAutorApellidos();
    }
    public boolean getPremioAutor(int nLibros){
        return this.book[nLibros].getAutorBoolean();
    }
    
    public int getPaginasLibro(int nLibro){
        return this.book[nLibro].getPaginas();
    }

    public int getLibrosCreados(){
        return librosCreados;
    }

    public void setVelLectura(int nLibro , int lecture_time){
        this.book[nLibro].setLecture_time(lecture_time);
    }

    public int getTlm (int nLibro){
        return this.book[nLibro].tlm();

    }

    ///////////////////////////////////////// METODOS //////////////////////////////////////////

    public void crearAlmacen(int tam /* Cuantos libros creará  */){
        int i = 0;
        librosCreados = 0;
        for(i=0; i< tam ; i++){  //crea libros vacíos en el almacen
            librosCreados++; // cuenta cuantos libros creará
          this.book[i] = new Libro();
           }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
}
