public class Expendedor {

    private Deposito<Producto> depositoCocaCola;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoSuper8;
    private Deposito<Moneda> depositoMonedas;

    public Expendedor(int cantidad) {
        depositoCocaCola = new Deposito<Producto>();
        depositoSprite = new Deposito<Producto>();
        depositoFanta = new Deposito<Producto>();
        depositoSnickers = new Deposito<Producto>();
        depositoSuper8 = new Deposito<Producto>();
        depositoMonedas = new Deposito<Moneda>();
        for(int i = 0; i < cantidad; i++){
            depositoCocaCola.add(new CocaCola(100+i));
            depositoSprite.add(new Sprite(200+i));
            depositoFanta.add(new Fanta(300+i));
            depositoSnickers.add(new Snickers(400+i));
            depositoSuper8.add(new Super8(500+i));
        }

    }

    public Producto comprarProducto(Moneda m, ProductosEnum eleccion) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException{
        if(m == null){
            throw new PagoIncorrectoException();
        }
        if(m.getValor() < eleccion.getPrecio()){
            throw new PagoInsuficienteException();
        } else {
            Producto auxiliar;
            switch (eleccion){
                case COCACOLA -> {
                    auxiliar = depositoCocaCola.get();
                    if(auxiliar != null){
                        procesarMonedas(ProductosEnum.COCACOLA.getPrecio(), depositoMonedas, m);
                        return auxiliar;
                    }
                }
                case FANTA -> {
                    auxiliar = depositoFanta.get();
                    if(auxiliar != null){
                        procesarMonedas(ProductosEnum.FANTA.getPrecio(), depositoMonedas, m);
                        return auxiliar;
                    }
                }
                case SPRITE -> {
                    auxiliar = depositoSprite.get();
                    if(auxiliar != null){
                        procesarMonedas(ProductosEnum.SPRITE.getPrecio(), depositoMonedas, m);
                        return auxiliar;
                    }
                }
                case SUPER8 -> {
                    auxiliar = depositoSuper8.get();
                    if(auxiliar != null){
                        procesarMonedas(ProductosEnum.SUPER8.getPrecio(), depositoMonedas, m);
                        return auxiliar;
                    }
                }
                case SNICKERS -> {
                    auxiliar = depositoSnickers.get();
                    if(auxiliar != null){
                        procesarMonedas(ProductosEnum.SNICKERS.getPrecio(), depositoMonedas, m);
                        return auxiliar;
                    }
                }
            }


            throw new NoHayProductoException();
        }
    }

    private void procesarMonedas(int precioEnum, Deposito<Moneda> depositoMoneda, Moneda m){
        int auxPrecio = m.getValor() - precioEnum;
        while (auxPrecio > 0) {
            depositoMoneda.add(new Moneda100());
            auxPrecio -= 100;
        }
    }

    public Moneda getVuelto(){
        return this.depositoMonedas.get();
    }

}
