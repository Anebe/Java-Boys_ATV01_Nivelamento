
package ed;

import java.util.Stack;

import comum.EstruturaDeDado;

public class Pilha extends Stack<Object> implements EstruturaDeDado{
    private int length;

    public Pilha(){
        length = 0;
    }
    
    public int getLength(){
        return length;
    }
    
    public void adicionar(Object elemento){
        length++;
        super.push(elemento);
    }
    
    public void adicionar(Object[] elemento){
        for (Object object : elemento) {
            push(object);
        }
    }

    public Object buscar(Object elemento){
        Object result = null;
        Pilha aux = new Pilha();

        while(!empty() && !pegar().equals(elemento)){
            aux.adicionar(remover());
        }

        if(!empty()){
            result = pegar();
        }

        while(!aux.empty()){
            push(aux.pop());
        }
        return result;
    }    
    public Object remover(){
        if(!empty()){
            length--;
            return super.pop();
        }else{
            return null;
        }
    }
    public Object remover(Object elemento){
        if(getLength() > 0){
            if(elemento != null){
            Object result = null;
            Pilha aux = new Pilha();

            while(!empty()){
                result = remover();
                if(result.equals(elemento)){
                    break;
                }
                else{
                    aux.push(result);
                }
            }
            //Caso não encontre
            if(empty() && !result.equals(elemento)){
                result = null;
            }

            while(!aux.empty()){
            push(aux.pop());
        }

            return result;
            }else{
                return remover();
            }
       }else{
        return null;
       }
        
    }
    /*public Object pop(int pos){
        Object result;
        Pilha aux = new Pilha();   
        if(!empty() && pos <=length){
            for(int i = length - pos; i>0; i--){
                aux.push(pop());
            }
            result = pop();
            while(!aux.empty()){
                push(aux.pop());
            }
            return result;
        }else{
            return null;
        }
    }*/

    public Object pegar(){
        if(!empty()){
            return super.peek();
        }else{
            return null;
        }
    }
    public String imprimir(){
        return toString();
    }
    public String toString(){
        StringBuilder result = new StringBuilder();;
        Pilha aux = new Pilha();
        while(!empty()){
            aux.push(pop());
        }
        while(!aux.empty()){
            result.append(push(aux.pop()) + ", ");
        }
        return result.toString();
    }

}
