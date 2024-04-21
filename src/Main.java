import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException; 
import java.util.ArrayList;

/**
 * Este programa lee un archivo .csv donde dependiendo de cual figura sea creara un cuadrado,circulo o triangulo
 * Además despues habra un menu con varías opciones
 * @author Mparr
 * @version 1.0
 */
public class Main { 
    static ArrayList<Figura> misFiguras = new ArrayList<>(); 
    
    public static void main(String[] args) {
        cargarArchivo();
        mostrar();  
    }//Fin de main

    public static void cargarArchivo() {
        String fileName = "figuras.csv";
        fileName = "C:\\Users\\santi\\Desktop\\figuras.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;            line = br.readLine();
                  while ((line = br.readLine()) != null) {
                  String[] parts = line.split(";");
                  if (parts.length > 0) {
                  crearFigura(parts);                }}
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }//Fin de cargarArchivo

    public static void crearFigura(String[] parts) {
                  String figura = parts[0];   
                  switch (figura) {         
                  case "circulo":            
                  float radio = Float.parseFloat(parts[1]);      
                  misFiguras.add(new Circulo(figura, (int) radio));
                  break;           
                  case "cuadrado":    
                  float lado = Float.parseFloat(parts[1]);     
                  misFiguras.add(new Cuadrado(figura,(int)lado));
                  break;          
                  case "rectangulo":      
                  float base = Float.parseFloat(parts[1]);      
                  float altura = Float.parseFloat(parts[2]);      
                  misFiguras.add(new Rectangulo(figura,(int)base,(int) altura));
                  break;        
                  default:           
                  System.out.println("No se crea objeto");  
                 }//Fin de switch
    }//Fin de crearFigura
                  public static void mostrar(){
                  for (Figura figura : misFiguras) { 
                  if (figura instanceof Circulo)
                  { Circulo circulo = (Circulo) figura;   
                  System.out.println("Círculo: " + circulo.getNombre()+ " area: "+ circulo.area() + " perimetro: "+circulo.perimetro());
                  } else if (figura instanceof Cuadrado) {     
                  Cuadrado cuadrado = (Cuadrado) figura;      
                  System.out.println("Cuadrado: " + cuadrado.getNombre()+ " area: "+ cuadrado.area() + " perimetro: "+cuadrado.perimetro()); 
                  } else if (figura instanceof Rectangulo) {              
                  Rectangulo rectangulo = (Rectangulo) figura;    
                 System.out.println("Rectángulo: " + rectangulo.getNombre() + " area: "+ rectangulo.area() + " perimetro: "+rectangulo.perimetro());
                  }
                  }   
                     }//Fin de mostrar
             }//Fin del main