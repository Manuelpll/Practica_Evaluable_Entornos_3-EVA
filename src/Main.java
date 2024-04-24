import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException; 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Este programa lee un archivo .csv donde dependiendo de cual figura sea creara un cuadrado,circulo o triangulo
 * Además despues habra un menu con varías opciones
 * @author Mparr
 * @version 1.0
 */
public class Main { 
    static ArrayList<Figura> misFiguras = new ArrayList<>(); 
    //Para hacer test alt-Enter
    public static void main(String[] args) {
        cargarArchivo();
       menu();
    }//Fin de main

    public static void menu() {
        //Zona de declaracion de variables
        int eleccion;
        boolean salir =false;
        //Zona de inicializacion
        Scanner scanner = new Scanner(System.in);
        //Zona de salida
        do {
            try {

                System.out.println("""
                        1-> Calcular area
                        2-> Calcular perimetro
                        3-> Duplica
                        4-> Divide2
                        0-> Salir""");
                eleccion = scanner.nextInt();
                scanner.nextLine();
                switch (eleccion) {
                    case 1:
                        area();
                        break;
                    case 2:
                        perimetro();
                        break;
                    case 3:
                        duplica();
                        break;
                    case 4:
                        divide2();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }//Fin switch
            }catch (InputMismatchException e){
                System.out.println("Inserta una de las opciones validas");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Error");
                scanner.nextLine();
            }//Fin try-catch
        } while (!salir);
    }//Fin de menu

    public static void divide2() {
        if (!misFiguras.isEmpty()) {
            for (Figura figura : misFiguras) {
                if (figura instanceof Circulo) {
                    Circulo circulo4 = (Circulo) figura;
                     circulo4.divide2();
                    System.out.println("Figura"+circulo4.nombre+"Valor del radio: " +circulo4.radio);
                } else if (figura instanceof Cuadrado) {
                    Cuadrado cuadrado4 = (Cuadrado) figura;
                    cuadrado4.divide2();
                    System.out.println("Figura"+ cuadrado4.nombre+"Valor del Lado: "+cuadrado4.lado );
                } else if (figura instanceof Rectangulo) {
                    Rectangulo rectangulo4 = (Rectangulo) figura;
                     rectangulo4.divide2();
                    System.out.println("Figura"+rectangulo4.nombre+"Valor de la altura: " + rectangulo4.altura+"\n"+"Valor de la base"+rectangulo4.base) ;
                } else {
                    System.out.println("No existe esta figura");
                }//Fin del 2º if-else
            }//Fin for
        } else {
            System.out.println("La lista de figuras está vacía.");
        }//Fin de if-else
    }//Fin  de divide2

    public static void duplica() {
        if (!misFiguras.isEmpty()) {
            for (Figura figura : misFiguras) {
                if (figura instanceof Circulo) {
                    Circulo circulo3 = (Circulo) figura;
                    circulo3.duplica();
                    System.out.println("Figura:"+circulo3.nombre+"Valor del radio: " +circulo3.radio);
                } else if (figura instanceof Cuadrado) {
                    Cuadrado cuadrado3 = (Cuadrado) figura;
                    cuadrado3.duplica();
                    System.out.println("Figura:"+ cuadrado3.nombre+"Valor del Lado: "+cuadrado3.lado);
                } else if (figura instanceof Rectangulo) {
                    Rectangulo rectangulo3 = (Rectangulo) figura;
                  rectangulo3.duplica();
                    System.out.println("Figura"+rectangulo3.nombre+"Valor de la altura: " + rectangulo3.altura+"\n"+"Valor de la base"+rectangulo3.base);
                } else {
                    System.out.println("No existe esta figura");
                }//Fin del 2º if-else
            }//Fin for
        } else {
            System.out.println("La lista de figuras está vacía.");
        }//Fin de if-else
    }//Fin de duplica

    public static void perimetro() {
        if (!misFiguras.isEmpty()) {
            for (Figura figura : misFiguras) {
                if (figura instanceof Circulo) {
                    Circulo circulo2 = (Circulo) figura;
                   int perimetroCi = circulo2.perimetro();
                    System.out.println("Figura:"+circulo2.nombre+"El perimetro es: " + perimetroCi);
                } else if (figura instanceof Cuadrado) {
                    Cuadrado cuadrado2 = (Cuadrado) figura;
                    int perimetroCu= cuadrado2.perimetro();
                    System.out.println("Figura:"+ cuadrado2.nombre+"El perimetro del cuadrado es: " + perimetroCu);
                } else if (figura instanceof Rectangulo) {
                    Rectangulo rectangulo2 = (Rectangulo) figura;
                    int perimetroR = rectangulo2.perimetro();
                    System.out.println("Figura"+rectangulo2.nombre+"El perimetro es: " +perimetroR);
                } else {
                    System.out.println("No existe esta figura");
                }//Fin del 2º if-else
            }//Fin for
        } else {
            System.out.println("La lista de figuras está vacía.");
        }//Fin de if-else
    }//Fin de perimetro

    public static void area() {
        if (!misFiguras.isEmpty()) {
            for (Figura figura : misFiguras) {
                if (figura instanceof Circulo) {
                    Circulo circulo1 = (Circulo) figura;
                    int areaCi = circulo1.area();
                    System.out.println("Figura:"+circulo1.nombre+"El área del círculo es: " + areaCi);
                } else if (figura instanceof Cuadrado) {
                    Cuadrado cuadrado1 = (Cuadrado) figura;
                   int  areaCu = cuadrado1.area();
                    System.out.println("Figura:"+ cuadrado1.nombre+"El área del cuadrado es: " + areaCu);
                } else if (figura instanceof Rectangulo) {
                    Rectangulo rectangulo1 = (Rectangulo) figura;
                    int areaR = rectangulo1.area();
                    System.out.println("Figura"+rectangulo1.nombre+"El área del rectángulo es: " + areaR);
                } else {
                    System.out.println("No existe esta figura");
                }//Fin del 2º if-else
            }//Fin for
        } else {
            System.out.println("La lista de figuras está vacía.");
        }//Fin de if-else
    }//Fin de area

    public static void cargarArchivo() {
        String fileName = "figuras.csv";
        fileName = ".\\src\\figuras.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                line = br.readLine();
                  while ((line = br.readLine()) != null) {
                  String[] parts = line.split(";");
                  if (parts.length > 0) {
                  crearFigura(parts);
                  }//Fin if
                     }//Fin While
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }//Fin try-catch
    }//Fin de cargarArchivo

    public static void crearFigura(String[] parts) {
                  String figura = parts[0];   
                  switch (figura) {         
                  case "circulo":            
                      int radio = Integer.parseInt(parts[1]);
                      misFiguras.add(new Circulo(figura,radio));
                      break;
                  case "cuadrado":    
                     int lado =Integer.parseInt(parts[1]);
                     misFiguras.add(new Cuadrado(figura,lado));
                     break;
                  case "rectangulo":      
                     int base = Integer.parseInt(parts[1]);
                     int altura = Integer.parseInt(parts[2]);
                     misFiguras.add(new Rectangulo(figura,base, altura));
                     break;
                  default:           
                      System.out.println("No se crea objeto");
                 }//Fin de switch
    }//Fin de crearFigura

             }//Fin del main