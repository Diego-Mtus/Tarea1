import java.util.ArrayList;

/** Main principal que realiza pruebas fijas del correcto funcionamiento de cada clase creada, y prueba que las excepciones
 * se atrapen cuando se necesite. <p>Se realizan pruebas de cada caso posible.</p> */
public class Main {
    public static void main(String[] args) {


        Deposito<Moneda> depositoMonedas = new Deposito<>();
        depositoMonedas.add(new Moneda100());
        depositoMonedas.add(new Moneda1000());
        depositoMonedas.add(new Moneda100());
        depositoMonedas.add(new Moneda500());
        depositoMonedas.add(new Moneda100());
        depositoMonedas.add(new Moneda1000());

        System.out.println("\nPruebas del funcionamiento de deposito de Monedas con método sort() junto a  método toString():\n");

        // Prueba de print de ArrayList sin y con sort
        ArrayList<Moneda> ordenado = depositoMonedas.getArrayList();
        System.out.println("Valores de las monedas en arraylist sin ordenar:");
        for(Moneda i : ordenado){
            System.out.println(i.toString());
        }

        ordenado.sort(Moneda::compareTo);

        System.out.println("\nValores de las monedas en arraylist ordenados usando sort():");
        for(Moneda i : ordenado){
            System.out.println(i.toString());
        }

        System.out.println("\nPrueba de usar nuevamente getArrayList para mostrar que orden original no se modifica, sino que se copia:");
        ArrayList<Moneda> pruebaDeCopiaNoReferencia = depositoMonedas.getArrayList();
        for(Moneda i : pruebaDeCopiaNoReferencia){
            System.out.println(i.toString());
        }

        Expendedor expendedor = new Expendedor(1);
        System.out.println("\nPruebas del expendedor de forma independiente.\n");

        System.out.println("Prueba 1: Compra normal");
        try {
            Producto pruebaProducto = expendedor.comprarProducto(new Moneda1000(), ProductosEnum.COCACOLA);
            System.out.println(pruebaProducto + " con número de serie " + pruebaProducto.getSerie());
        } catch (PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e ) {
            System.out.println("Error" + e);
        }

        System.out.println("\nPrueba 2: Compra con moneda null");
        try {
            Producto pruebaProducto = expendedor.comprarProducto(null, ProductosEnum.COCACOLA);
            System.out.println(pruebaProducto);
        } catch (PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e ) {
            System.out.println("Error: " + e);
        }

        System.out.println("\nPrueba 3: Compra con plata insuficiente");
        try {
            Producto pruebaProducto = expendedor.comprarProducto(new Moneda100(), ProductosEnum.COCACOLA);
            System.out.println(pruebaProducto);
        } catch (PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e ) {
            System.out.println("Error: " + e);
        }

        System.out.println("\nPrueba 4: Compra sin stock");
        try {
            Producto pruebaProducto = expendedor.comprarProducto(new Moneda1000(), ProductosEnum.COCACOLA);
            System.out.println(pruebaProducto);
        } catch (PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e ) {
            System.out.println("Error: " + e);
        }

        System.out.println("\nPruebas de comprador");

        Expendedor nuevo = new Expendedor(3);

        System.out.println("\nComprador intenta pagar con moneda null:");
        Comprador compradorSinDinero = new Comprador(null, 1,nuevo);

        System.out.println("\nComprador intenta pagar con poco dinero:");
        Comprador compradorPobre = new Comprador(new Moneda100(), 1,nuevo);
        System.out.println("Vuelto: $" + compradorPobre.cuantoVuelto());

        System.out.println("\nComprador puede pagar lo que quiere: ");
        Comprador compradorExitoso = new Comprador(new Moneda1000(), 2, nuevo);
        System.out.println("Vuelto: $" + compradorExitoso.cuantoVuelto());
        System.out.println(compradorExitoso.queCompro());


        System.out.println("\nPrueba de comprador que comprará todos los productos de un expendedor + 1 (Es decir, eventualmente pagará sin stock)");
        int cantidadParaLoop = 3;
        Expendedor expLoop = new Expendedor(cantidadParaLoop);

        for(int i = 0; i <= cantidadParaLoop * ProductosEnum.values().length; i++){
            Comprador compLoop = new Comprador(new Moneda1000(), (i % ProductosEnum.values().length) + 1, expLoop);
            System.out.println(compLoop.queCompro());
            System.out.println("Vuelto: $" + compLoop.cuantoVuelto() + "\n");

        }


        System.out.println("Prueba de cambiar el precio de un producto, se comprará el producto 2 veces y el cambió se verá reflejado en el vuelto.\n");

        Expendedor expCambioPrecios = new Expendedor(2);
        Comprador cambio1 = new Comprador(new Moneda1000(), ProductosEnum.SNICKERS.getIndice(), expCambioPrecios);
        System.out.println(cambio1.queCompro());
        System.out.println("Vuelto: $" + cambio1.cuantoVuelto() + "\n");

        ProductosEnum.SNICKERS.setPrecio(900);
        Comprador cambio2 = new Comprador(new Moneda1000(), ProductosEnum.SNICKERS.getIndice(), expCambioPrecios);
        System.out.println(cambio1.queCompro());
        System.out.println("Vuelto: $" + cambio2.cuantoVuelto() + "\n");


    }
}