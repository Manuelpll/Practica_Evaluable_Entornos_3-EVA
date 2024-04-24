/**
 * Clase hija de figura
 */
public class Cuadrado implements Figura{
    String nombre;
    int lado;
    public Cuadrado(String nombre, int lado) {
        this.nombre = nombre;
        this.lado = lado;
    }//Fin del constructor

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//Fin de setNombre

    public String getNombre() {
        return nombre;
    }//Fin de getNombre

    public void setLado(int lado) {
        this.lado = lado;
    }//Fin de setLado

    public int getLado() {
        return lado;
    }//Fin de getLado


    @Override
    public int area() {
        return lado*lado;
    }//Fin de area

    @Override
    public int perimetro() {
        return lado*4;
    }//Fin de perimetro

    @Override
    public void duplica() {
        if(lado >1000){
            throw  new IllegalArgumentException("No se puede duplicar más el lado");
        }else {
            lado = lado * 2;
        }//Fin if-else
    }//Fin de duplicar

    @Override
    public void divide2() {
       if(lado!=0){
           lado=lado/2;
       }else {
           throw new IllegalArgumentException("Division imposible");
       }//Fin if-else
    }//Fin de divide2
}///Fin de Cuadrado
