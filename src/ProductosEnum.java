public enum ProductosEnum {

    // Bebidas
    COCACOLA,
    SPRITE,
    FANTA,

    // Dulces
    SNICKERS,
    SUPER8;

    private int precio;

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }


}
