public enum ProductosEnum {

    // Bebidas
    COCACOLA(1, 500, "Coca-Cola"),
    SPRITE(2, 500, "Sprite"),
    FANTA(3, 400, "Fanta"),

    // Dulces
    SNICKERS(4, 500, "Snickers"),
    SUPER8(5, 300, "Super8");

    final int indice;
    private int precio;
    final String nombre;

    ProductosEnum(int indice, int precio, String nombre){
        this.indice = indice;
        this.precio = precio;
        this.nombre = nombre;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }

    public int getIndice() {
        return this.indice;
    }

    public String getNombre(){
        return this.nombre;
    }

}
