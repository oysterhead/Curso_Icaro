public class Coche extends Vehiculo{
    private int numPuertas;

    public Coche(String marca, String modelo, int numPuertas) {
        super(marca, modelo);
        this.numPuertas = numPuertas;

    }

    public int getNumPuertas(){
        return this.numPuertas;
    }
}
