/** Representación especifica de una bebida Sprite, que es una {@code Bebida} y {@code Producto},
 * por lo tanto, se puede usar.
 * */

public class Sprite extends Bebida{

    /** Constructor que recibe una serie y se la pasa a su superclase {@code Bebida}, que a su vez, se la pasa a {@code Producto}.
     * Simula el identificador único de esa Sprite.
     * @param serie Número de serie deseado para Sprite.*/
    public Sprite(int serie) {
        super(serie);
    }

    /** Método que sobreescribe el método heredado de {@code Bebida} para desplegar el consumo de la Sprite.
     * @return Retorna "Se ha tomado Sprite."*/
    @Override
    public String usar() {
        return super.usar() + "Sprite.";
    }
}
