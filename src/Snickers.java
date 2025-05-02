/** Representación especifica de un Snickers, que es un {@code Dulce} y {@code Producto},
 * por lo tanto, se puede usar.
 * */
public class Snickers extends Dulce{

    /** Constructor que recibe una serie y se la pasa a su superclase {@code Dulce}, que a su vez, se la pasa a {@code Producto}.
     * Simula el identificador único de ese Snickers.
     * @param serie Número de serie deseado para Snickers.*/
    public Snickers(int serie){
        super(serie);
    }

    /** Método que sobreescribe el método heredado de {@code Dulce} para desplegar el consumo de Snickers.
     * @return Retorna "Se ha comido Snickers."*/
    public String usar(){ return super.usar() + "Snickers.";}
}