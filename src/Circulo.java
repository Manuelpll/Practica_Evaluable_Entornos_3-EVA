public class Circulo implements Figura {
    String nombre;
    int radio;
    public Circulo(String nombre, int radio) {
        this.nombre = "Circulo";
        this.radio = radio;
    }//Fin de Circulo

    public int getRadio() {
        return radio;
    }//Fin get radio

    public String getNombre() {
        return nombre;
    }//Fin getNombre

    public void setRadio(int radio) {
        this.radio = radio;
    }//Fin setRadio
    @Override
    public int area() {
        return (int) (Math.PI*(radio * radio));
    }//Fin de area

    @Override
    public int perimetro() {
        return (int) (Math.PI*radio+radio);
    }//Fin perimetro

    @Override
    public void duplica() {
        radio=radio*2;
    }//Fin de duplica

    @Override
    public void divide2() {
        if(radio>0){
            radio=radio/2;
        }else{
            throw new IllegalArgumentException("Division incorrecta");
        }//Fin if-else
    }//Fin de divide2
}
