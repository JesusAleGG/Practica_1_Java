import modelo.*;

import java.util.Calendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Calendar actual = Calendar.getInstance(); // Variable de tipo Calendar para una validación de más adelante
        
        Scanner scan = new Scanner(System.in); // Una estancia de la clase escaner para pedir datos de entrada al usuario

        char opcion; char tienePremio =' '; // Variables char

        String titulo = ""; String nombreA = ""; String apellidosA= ""; String yesOrno = " ";// Variables de la clase String

        // Variables de tipo entera

        int paginas = 0; int ano_pub = 0; int totalTiempoLectura = 0;
        int respuesta_usu = 0;  int contLibros = 0; int tamUsu = 0;
        int tam =1000; int flag =0; int vel_lectura =0; int i=0;
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //// int tam =1000;  Esto marcará el número máximo de libros que podremos almacenar en el almacen   ////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
       
        double precio = 0.0; double totalPrecioAlmacen = 0; // Variables tipo double
        
        //Variables de tipo booleano 
        boolean premioAutor = false;
        boolean salir = false;
        ////////////////////////////

        // Nuestra estancia de la clase almacen

        Almacen almacen = new Almacen(tam);
        
    do{ // MENU //
    System.out.printf("|----------------------------------------------|\n");
    System.out.printf("| MIS LIBROS |\n");
    System.out.printf("|----------------------------------------------|\n");
    System.out.printf("1) Nuevo almacén de libros\n");
    System.out.printf("2) Establecer ritmo de lectura (páginas por minuto)\n");
    System.out.printf("3) Añadir un nuevo libro al almacén\n");
    System.out.printf("4) Mostrar información actual de libros\n");
    System.out.printf("5) Salir (se borrará toda la información)\n");
    System.out.printf("|----------------------------------------------|\n");
    System.out.printf("Seleccione una opción (1-4):\n\n");
    
    do{     // Verificación de Dato introducido por el usuario //
        try{
        respuesta_usu = scan.nextInt();
         }catch(Exception e){
        System.out.println("error en la seleccion, argumentos validos: (1,2,3,4 y 5)\n");
        respuesta_usu=0;
        scan.nextLine();
        }
        if(respuesta_usu>5 || respuesta_usu<=0){
            System.out.println("LA SELECCION NO ES VALIDA (1-5)\n");
            scan.nextLine();
        }
      }while(respuesta_usu>5 || respuesta_usu<=0);

      scan.nextLine();
      switch(respuesta_usu) {// los casos dependiendo de la elección del usuario
        case 1:
                
                System.out.println("Dame la cantidad de libros a guardar");
                do{ 
                try{
                    tamUsu= scan.nextInt();
                    flag =1;
                     }catch(Exception e){
                    System.err.println("error en la seleccion, argumentos validos: enteros >= 0");
                    scan.nextLine();
                    flag=0;
                 }
                    if(tamUsu<0){
                        System.out.println("LA SELECCION NO ES VALIDA\n");
                        scan.nextLine();
                        flag=0;
                    }
                }while(flag ==0);
                scan.nextLine();// Borra el buffer del Scanner
                contLibros =0;
                almacen.crearAlmacen(tamUsu); // creará una estancia de tipo Libro en el array que está declarado en Almacen.java
                

              

        break;
        case 2: 

        
        do{ 
        System.out.println("Dime el libro a asignarle velocidad de lectura");
        opcion =' ';
        try{
            i = scan.nextInt();
            flag =1;
             }catch(Exception e){
            System.err.println("error en la seleccion, argumentos validos: enteros >= 0");
            scan.nextLine();// borra el buffer del Scanner
            flag=0;
         }
            if((i-1) <0 || i>almacen.getLibrosCreados() ){
                System.out.println("LA SELECCION NO ES VALIDA\n");
                if(i>almacen.getLibrosCreados()){
                    System.out.println("No existe libro n "+ i);
                    System.out.printf("los libros posibles tienen que ser <= %d\n",almacen.getLibrosCreados());
                    scan.nextLine();
                    do{
                    System.out.println("Quieres seguir insertando velocidad de lectura?(s/n)");
                    opcion = scan.next().charAt(0);
                    }while(opcion != 's' && opcion != 'n');
                    if(opcion == 'n'){
                        break;
                    }
                    
                }
                scan.nextLine();
                flag=0;
            }
        }while(flag == 0);

        if(opcion == 'n'){
            break;
        }

        System.out.println("dame la velocidad de lectura del libro en paginas/minuto ");
        do{ 
        try{
            vel_lectura = scan.nextInt();
            flag =1;
             }catch(Exception e){
            System.err.println("error en la seleccion, argumentos validos: enteros >= 0");
            scan.nextLine();
            flag=0;
         }
            if(vel_lectura <0){
                System.out.println("LA SELECCION NO ES VALIDA\n");
                scan.nextLine();
                flag=0;
            }
        }while(flag == 0);

      
        almacen.setVelLectura(i-1, vel_lectura);// accederá al array situando el atributo de la clase libro "vel_lectura" al libro numero seleccionado
       
        break;
        
        case 3:
            
            if((contLibros + 1) > almacen.getLibrosCreados()){ // por si el usuario intenta agregar datos a un libro que aún no se ha creado
                System.err.println("Se ha excedido el almacenamiento inicializado");
                break;
            }
            //VALIDACION DE TITULO
            do{ 
                System.out.printf("Dame el titulo del libro n (%d)\n",(contLibros+1));
                try{
                    titulo = scan.nextLine();
                    flag =1;
                     }catch(Exception e){
                    System.err.println("error en la seleccion, argumentos validos: String");
                    scan.nextLine();
                    flag=0;
                 }
            }while(flag ==0);
            almacen.setTitulo(titulo,contLibros);
            
           // VALIDACION NUMERO DE PAGINAS
           do{ 
            System.out.printf("Dame el numero de paginas del libro n (%d)\n",(contLibros+1));
            try{
                paginas = scan.nextInt();
                flag =1;
                 }catch(Exception e){
                System.err.println("error en la seleccion, argumentos validos: enteros >0");
                scan.nextLine();
                flag=0;
             } if (paginas <= 0){
                System.err.println("el numero de paginas han de ser >0");
                flag = 0;
             }
        }while(flag ==0);
        almacen.setPaginas(paginas, contLibros);
            
            // VALIDACION AÑO DE PUBLICACIÓN
            do{ 
                System.out.printf("Dame el ano de publicacion del libro n (%d)\n",(contLibros+1));
                try{
                    ano_pub= scan.nextInt();
                    flag =1;
                     }catch(Exception e){
                    System.err.println("error en la seleccion, argumentos validos: enteros >0");
                    scan.nextLine();
                    flag=0;
                 } if (ano_pub <= 0 || ano_pub > actual.get(Calendar.YEAR)){
                    System.err.println("el ano de publicacion han de ser >0 ");
                    flag=0;
                 }
            }while(flag ==0);
            almacen.setAno_pub(ano_pub,contLibros);

            // VALIDACION PRECIO
            scan.nextLine();
            do{ 
                System.out.printf("Dame el precio del libro n (%d)\n",(contLibros+1));
                try{
                    precio = scan.nextDouble();
                    flag =1;
                     }catch(Exception e){
                    System.err.println("error en la seleccion, argumentos validos: Double >0");
                    scan.nextLine();
                    flag=0;
                 } if (precio < 0.0){
                    System.err.println("el precio ha de ser >0 ");
                    flag =0;
                 }
            }while(flag ==0);
            almacen.setPrecio(precio, contLibros);
            scan.nextLine();
            // VALIDACION DE AUTOR
            do{ 
                System.out.printf("Dame el autor del libro n (%d)\n",(contLibros+1));
                try{
                    nombreA = scan.nextLine();
                    flag =1;
                     }catch(Exception e){
                    System.err.println("error en la seleccion, argumentos validos: String");
                    scan.nextLine();
                    flag=0;
                 }
            }while(flag ==0);
             // VALIDACION APELLIDOS AUTOR
            do{ 
                System.out.printf("Dame el apellido del autor del libro n (%d)\n",(contLibros+1));
                try{
                    apellidosA = scan.nextLine();
                    flag =1;
                     }catch(Exception e){
                    System.err.println("error en la seleccion, argumentos validos: String");
                    scan.nextLine();
                    flag=0;
                 }
            }while(flag ==0);
            /// VALIDACION PREMIO PLANETA
            do{ 
                System.out.printf( "el autor del libro n (%d) tiene un premio planeta? (s/n) \n",(contLibros+1));
                try{
                    tienePremio = scan.next().charAt(0);
                    flag =1;
                     }catch(Exception e){
                    System.err.println("error en la seleccion, argumentos validos: String");
                    scan.nextLine();
                    flag=0;
                 }
                 if(tienePremio == 's'){
                    premioAutor = true;
                 }
                 if(tienePremio == 'n'){
                    premioAutor = false;
                 }
                 if(tienePremio != 's' && tienePremio != 'n'){
                    System.err.println("La seleccion solo puede ser s = Si o a n = No");
                    scan.nextLine();
                    System.out.println("El carácter introducido es: " + tienePremio);
                    flag = 0;
                 }
                 
            }while(flag ==0);
            almacen.setAutor(nombreA, apellidosA, premioAutor , contLibros);
        
        scan.nextLine();
        System.out.println("\n");
        contLibros++;

        break;
        case 4: // IMPRIMIRÁ POR PANTALLA LOS DATOS ALMACENADOS EN EL ARRAY DE ALMACEN
        totalPrecioAlmacen=0;
        totalTiempoLectura = 0;
        System.out.printf("|--------------------------------------------------------------------------------------------------------------------------------------------------|\n");
        System.out.printf("| LIBROS EN EL ALMACÉN                                                                                                                             |\n");
        System.out.printf("|--------------------------------------------------------------------------------------------------------------------------------------------------|\n");

        System.out.printf("| Título           | Ano publicacion         |  Autor              | Premio planeta               | Paginas | Tiempo lectura en minutos |   Precio |\n");
        for(i=0;i<contLibros;i++){
            if(almacen.getPremioAutor(i)){
                yesOrno = "Si";
            }else{
                yesOrno = "No";
            }
            totalPrecioAlmacen = totalPrecioAlmacen + almacen.getPrecio(i);
            totalTiempoLectura = totalTiempoLectura + almacen.getTlm(i);
        System.out.printf("| %s     | %d     | %s      | %s     | %d    | %d    | %.2f$ |\n",
        almacen.getTitulo(i),almacen.getAno_pub(i),(almacen.getNombreAutor(i)+" "+almacen.getApellidosAutor(i)),yesOrno,almacen.getPaginas(i),almacen.getTlm(i),almacen.getPrecio(i));
        }
        System.out.printf("|-------------------------------------------------------------------------|\n");
        System.out.printf("| Tiempo de lectura total del almacen: %d min |\n",totalTiempoLectura);
        System.out.printf("| Valor total del almacen: %.2f$ |\n",totalPrecioAlmacen);
        System.out.printf("|-------------------------------------------------------------------------|\n");
        System.out.printf("\n");
        break;
        case 5:
                salir = true;
        break;

    }
    }while(salir == false);
    scan.close(); // cierra la estancia de Scanner antes abierta
}}
