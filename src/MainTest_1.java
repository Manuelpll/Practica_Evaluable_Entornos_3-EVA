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
    }


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
}//Fin MainTest1