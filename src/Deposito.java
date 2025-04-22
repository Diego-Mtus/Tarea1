import java.util.ArrayList;

public class Deposito<T>{

    private T t;
    private ArrayList<T> arrayList;

    public Deposito(){
        arrayList = new ArrayList<T>();
    }

    public void add(T t){
        arrayList.add(t);
    }

    public T get(){
        if(!arrayList.isEmpty()){
            return arrayList.removeFirst();
        } else{
            return null;
        }
    }
}
