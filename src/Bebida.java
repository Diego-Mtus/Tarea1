public abstract class Bebida extends Producto{

    public Bebida(int serie) {
        super(serie);
    }

    @Override
    public String usar() {
        return "Se ha tomado ";
    }
}