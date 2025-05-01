import java.util.Scanner;

public class MainInteractivo {

    // Se debe actualizar manualmente de acuerdo a cuántas opciones definamos.
    static final int CANTIDAD_INDICE = 3;

    private static void pantallaPrincipal(){
        System.out.println("\nMenú principal");
        System.out.println("0. Salir.");
        System.out.println("1. Ver precio actual de los productos.");
        System.out.println("2. Cambiar el precio de productos.");
        System.out.println("3. Obtener moneda.");
        System.out.println("Escribe el número de la operación que quieres realizar, y presiona enter:");
    }



    public static int leerNumero(Scanner input, int cantidadOpciones){
        boolean inError = true;
        int eleccion = -1;

        while (inError) {

            if (input.hasNextInt()) {
                eleccion = input.nextInt();
            } else {
                input.next();
                System.out.println("Debes ingresar un número entero.");
                continue;
            }

            if (eleccion < 0 || eleccion > cantidadOpciones) {
                System.out.println("El número elegido está fuera de rango.");
                continue;
            }

            inError = false;
        }


        return eleccion;
    }


    public static void main(String[] args) {

        Scanner inputPrincipal = new Scanner(System.in);
        boolean loopMenu = true;
        Moneda monedaUsuario = null;

        while(loopMenu) {

            pantallaPrincipal();
            int eleccion = leerNumero(inputPrincipal, CANTIDAD_INDICE);
            System.out.println("Número elegido: " + eleccion);

            switch (eleccion) {
                case 0:
                    loopMenu = false;
                    break;

                case 1:
                    System.out.println("Precio de productos:");
                    for (ProductosEnum producto : ProductosEnum.values()) {
                        System.out.println(producto.getIndice() + ". " + producto.getNombre() + ": $" + producto.getPrecio());
                    }
                    break;

                case 2:
                    System.out.println("Elige el índice del producto que quieras cambiar el precio, o elige 0 para salir");
                    for (ProductosEnum producto : ProductosEnum.values()) {
                        System.out.println(producto.getIndice() + ". " + producto.getNombre() + ": $" + producto.getPrecio());
                    }

                    int elegirProductoCambio = leerNumero(inputPrincipal, ProductosEnum.values().length);
                    if (elegirProductoCambio == 0) {
                        break;
                    }
                    System.out.println("Se escogió " + ProductosEnum.values()[elegirProductoCambio -1].getNombre() + ", ¿Qué precio deseas ponerle?");
                    int cambioPrecio = leerNumero(inputPrincipal, Integer.MAX_VALUE);
                    ProductosEnum.values()[elegirProductoCambio - 1].setPrecio(cambioPrecio);
                    System.out.println("El nuevo precio asignado para " + ProductosEnum.values()[elegirProductoCambio - 1].getNombre() + " es de $" + ProductosEnum.values()[elegirProductoCambio - 1].getPrecio());
                    break;

                case 3:
                    if(monedaUsuario == null) {
                        System.out.println("Actualmente no se tiene ninguna moneda");
                    } else {
                        System.out.println("La moneda que se tiene actualmente es de $" + monedaUsuario.getValor());
                    }

                    System.out.println("Elige el índice de la moneda que quieras, o elige 0 para salir" +
                            "\n 1. $100" +
                            "\n 2. $500" +
                            "\n 3. $1000");
                    int eleccionMoneda = leerNumero(inputPrincipal, 3);
                    if(eleccionMoneda == 0) { break;}
                    monedaUsuario = switch (eleccionMoneda) {
                        case 1 -> new Moneda100();
                        case 2 -> new Moneda500();
                        case 3 -> new Moneda1000();
                        default -> monedaUsuario;
                    };
                    break;

            }

        }
        inputPrincipal.close();
        System.out.println("El programa ha finalizado exitosamente :)");

    }
}
