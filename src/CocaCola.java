/** Representación especifica de una bebida Coca-Cola, que es una {@code Bebida} y {@code Producto},
 * por lo tanto, se puede usar.
 * */
public class CocaCola extends Bebida{

    /** Constructor que recibe una serie y se la pasa a su superclase {@code Bebida}, que a su vez, se la pasa a {@code Producto}.
     * Simula el identificador único de esa Coca-cola.
     * @param serie Número de serie deseado para Coca-cola.*/
    public CocaCola(int serie) {
        super(serie);
    }

    /** Método que sobreescribe el método heredado de {@code Bebida} para desplegar el consumo de la Coca-cola.
     * @return Retorna "Se ha tomado Coca-Cola."*/
    @Override
    public String usar() {
        return super.usar() + "Coca-Cola.";
    }
}
