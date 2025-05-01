public abstract class Dulce extends Producto{

    public Dulce(int serie) {
        super(serie);
    }

    @Override
    public String usar() {
        return "Se ha comido ";
    }
}
