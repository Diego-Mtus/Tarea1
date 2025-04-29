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

}
