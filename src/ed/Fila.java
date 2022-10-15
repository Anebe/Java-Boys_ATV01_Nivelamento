package ed;

import java.util.ArrayList;

import comum.EstruturaDeDado;

public class Fila implements EstruturaDeDado{
    private ArrayList<Object> fila = new ArrayList<>();

    public boolean estaVazia(){
        return (this.fila.size() == 0);
    }

    public int tamanho(){
        return this.fila.size();
    }

    //Métodos
    public void adicionar(Object value){
        fila.add(value);
    }
    public void adicionar(Object[] value){
        for (Object object : value) {
            adicionar(object);
        }
    }
    public Object remover(){
        if(estaVazia()){
            System.out.println("Fila vazia!");
            return null;
        }else{
            return fila.remove(0);
        }
    }
    public Object remover(Object value){
        if(!estaVazia()){
            Fila aux = new Fila();
            Object testObj = null;

            do{
                testObj = fila.remove(0);
                if(!testObj.equals(value))
                    aux.adicionar(testObj);
            }while(!fila.isEmpty() && !testObj.equals(value));
            
            if(!testObj.equals(value)){
                testObj = null;
            }

            while(!aux.estaVazia()){
                adicionar(aux.remover());
            }

            return testObj;
        }else{
            return null;
        }
    }
    public Object buscar(int index){
        Object elemento;
        try{
            elemento = fila.get(index);
        }catch(IndexOutOfBoundsException error){
            elemento = null;
            System.out.println("Elemento não encontrado!");
        }
        return elemento;
    }
    public Object buscar(Object value){
        if(fila.contains(value)){
            return value;
        }else{
            return null;
        }
    }
    public String imprimir(){
        return toString();
    }
    @Override
    public String toString(){
        String msg = "";
        for (int i = 0; i < tamanho(); i++) {
            if(i==0){
                msg += buscar(i);
            }else{
                //msg += "<-"+buscar(i);
                msg += ", " + buscar(i);
            }
        }
        return msg;
    }

}
