import java.util.ArrayList;

/** Clase genérica que implementa un contenedor para almacenar cualquier tipo de objeto T mediante un {@code ArrayList}.
 * Contiene métodos para añadir elementos, recuperar elementos, y obtener una copia del arreglo.
 * */
public class Deposito<T>{

    /** Un ArrayList de tipo genérico T que se utiliza para el almacenamiento de los elementos del depósito. */
    private ArrayList<T> arrayList;

    /** Constructor por defecto que inicializa arrayList.*/
    public Deposito(){
        arrayList = new ArrayList<T>();
    }

    /** Método que añade un objeto del tipo T al depósito. Este objeto se agrega al final de {@code arrayList}.*/
    public void add(T t){
        arrayList.add(t);
    }

    /** Método que recupera y elimina el primer elemento del depósito.
     * @return Si {@code arrayList} tiene elementos, retorna el primer objeto y lo elimina de la lista.
     * Si {@code arrayList} no tiene elementos, retorna {@code null}.*/
    public T get(){
        if(!arrayList.isEmpty()){
            return arrayList.removeFirst();
        } else{
            return null;
        }
    }

    public ArrayList<T> getArrayList(){
        return new ArrayList<>(arrayList);
    }
}
