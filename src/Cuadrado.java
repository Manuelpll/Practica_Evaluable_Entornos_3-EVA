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
    }

    @Override
    public int perimetro() {
        return lado*4;
    }

    @Override
    public void duplica() {
        lado=lado*2;
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
