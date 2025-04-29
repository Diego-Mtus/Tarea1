abstract public class Moneda implements Comparable<Moneda>{

    static private int serieContador = 1;
    private int serie;

    public Moneda(){
        this.serie = serieContador;
        serieContador++;
    };

    public int getSerie(){
        return this.serie;
    }

    public abstract int getValor();

    @Override
    public String toString(){
        return "Moneda con serie " + this.getSerie() + " tiene valor de " + this.getValor();
    }

    @Override
    public int compareTo(Moneda m) {
        if(this.getValor() > m.getValor()){
            return 1;
        } else if (this.getValor() == m.getValor()){
            return 0;
        } else {
            return -1;
        }
    }
}
