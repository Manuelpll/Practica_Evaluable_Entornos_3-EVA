import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

public class MainTest_1 {
    @Test
    public void testCargarArchivoExistente() {
        String filename= "figuras.csv";
        filename=".\\src\\figuras.csv";
         Main.cargarArchivo();
         assertEquals(7,Main.misFiguras.size());
    }//testCargarExistente

    @Test
    public void testCargarArchivoIncorrecto() {
        String filename = "archivo_inexistente.csv";
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        String fileName = filename;
        Main.cargarArchivo();
        assertEquals("Error al leer el archivo: " + filename + "\n", errContent.toString());
    }//testCargarArchivaIncorrecto

   @Test
   public void crearFiguraPosible() {
       String[] parts = {"Circulo", "5"};
       Main.crearFigura(parts);
       assertEquals(4, Main.misFiguras.size());
    }//cargarArchivoInexistente

    @Test
    public void crearFiguraImposible() {
        String[] parts = {"Estrella", "lado"};
        Main.crearFigura(parts);
        assertEquals(3, Main.misFiguras.size());
    }//crearFiguraImposible
    @Test
    public  void  dividir2ConNingunValor() {
        Main.misFiguras.clear();
        Main.divide2();
        assertTrue(Main.misFiguras.isEmpty(), "La lista de figuras debe seguir estando vacía");
    }//Fin dividir2ConValor0
    @Test
    public  void dividir2Correcto () {
        Main.misFiguras.clear();
        Main.misFiguras.add(new Circulo("circulo", 8));
        Main.misFiguras.add(new Cuadrado("cuadrado", 10));
        Main.misFiguras.add(new Rectangulo("rectangulo", 6, 12));
        Main.divide2();
        assertEquals(4, ((Circulo) Main.misFiguras.get(0)).getRadio(), "El radio del círculo  se ha dividido correctamente");
        assertEquals(5, ((Cuadrado) Main.misFiguras.get(1)).getLado(), "El lado del cuadrado  se ha dividido correctamente");
        assertEquals(3, ((Rectangulo) Main.misFiguras.get(2)).getBase(), "La base del rectángulo  se ha dividido correctamente");
        assertEquals(6, ((Rectangulo) Main.misFiguras.get(2)).getAltura(), "La altura del rectángulo  se ha dividido correctamente");
    }// Fin dividir2Correcto
    @Test
   public void dividir2ConValor0() {
        Main.misFiguras.clear();
        Main.misFiguras.add(new Circulo("circulo", 0));
        Main.divide2();
        assertEquals(1, Main.misFiguras.size(), "La lista de figuras debe contener una figura");
        assertTrue(Main.misFiguras.get(0) instanceof Circulo, "La figura debe ser un círculo");
        assertEquals(0, ((Circulo) Main.misFiguras.get(0)).getRadio(), "El radio del círculo debe seguir siendo 0");
    }
}//Fin MainTest1