public class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda moneda, int cualProducto, Expendedor exp){
        try {
            Producto productoComprado = exp.comprarProducto(moneda, ProductosEnum.values()[cualProducto-1]);
            sonido = productoComprado.usar();
            vuelto = 0;
            Moneda aux = exp.getVuelto();
            while(aux != null){
                vuelto += aux.getValor();
                aux = exp.getVuelto();
            }
        } catch (PagoIncorrectoException e) {
            System.out.println("Comprador no pudo obtener producto debido a " + e.getMessage());
        } catch (NoHayProductoException | PagoInsuficienteException e){
            vuelto = moneda.getValor();
            System.out.println("Comprador no pudo obtener producto debido a " + e.getMessage());
            System.out.println("Su moneda ha sido devuelta.");
        }
    }   

    public int cuantoVuelto(){
        return this.vuelto;
    }

    public String queCompro(){
        return this.sonido;
    }
}
