public class Rectangulo implements Figura{
String nombre;
int base;
int altura;
public Rectangulo(String nombre, int base, int altura){
    this.nombre = "Rectangulo";
    this.base = base;
    this.altura = altura;
}//Fin del constructor

    public void setAltura(int altura) {
        this.altura = altura;
    }//Fin de setAltura

    public void setBase(int base) {
        this.base = base;
    }//Fin de setBase

    public int getBase() {
        return base;
    }//Fin de getBase

    public String getNombre() {
        return nombre;
    }//Fin de getNombre

    public int getAltura() {
        return altura;
    }//Fin de getAltura

    @Override
    public int area() {
        return base*altura;
    }//Fin de area

    @Override
    public int perimetro() {
        return (base*2)+(altura*2);
    }//Fin de perimetro

    @Override
    public void duplica() {
      base=base*2;
      altura=altura*2;
    }//Fin de duplica

    @Override
    public void divide2() {
      if(altura!=0 && base!=0){
          altura=altura/2;
          base=base/2;
      }else{
          throw new IllegalArgumentException("Divisíon incorecta");
      }//Fin if-else
    }//Fin de divide2
}//Fin de rectangulo
