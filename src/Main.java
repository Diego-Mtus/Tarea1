import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Deposito<Moneda> depositoMonedas = new Deposito<>();
        depositoMonedas.add(new Moneda100());
        depositoMonedas.add(new Moneda1000());
        depositoMonedas.add(new Moneda100());
        depositoMonedas.add(new Moneda500());
        depositoMonedas.add(new Moneda100());
        depositoMonedas.add(new Moneda1000());


        // Prueba de print de ArrayList sin y con sort
        ArrayList<Moneda> ordenado = depositoMonedas.getArrayList();
        System.out.println("Valores de las monedas en arraylist sin ordenar:");
        for(Moneda i : ordenado){
            System.out.println(i.toString());
        }


        System.out.println("\nValores de las monedas en arraylist ordenados:");
        ordenado.sort(Moneda::compareTo);
        for(Moneda i : ordenado){
            System.out.println(i.toString());
        }

        System.out.println("\nPrueba de uso de método getArrayList() para demostrar que arraylist original no se modifica:");
        ArrayList<Moneda> pruebaDeCopiaNoReferencia = depositoMonedas.getArrayList();
        for(Moneda i : pruebaDeCopiaNoReferencia){
            System.out.println(i.toString());
        }

    }
}