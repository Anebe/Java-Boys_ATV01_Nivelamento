
package ed;

import comum.EstruturaDeDado;

public class Lista_Dupla implements EstruturaDeDado{
    private No inicio;
    private No fim;
    private int tamanho;
    
    public void inserirInicio(Object info){
        No no = new No();
        no.setInfo(info);
        no.setAnterior(null);
        no.setProximo(null);
        if(inicio != null){
            inicio.setAnterior(no);
        }
        inicio = no;
        if (tamanho == 0){
            fim = inicio;
        }
        tamanho ++;
    }
    
    public Object retirarInicio(){
        if(inicio==null){
            return null;
        }
        Object aux = inicio.getInfo();
        inicio=inicio.getProximo();
        if(inicio != null){
            inicio.setAnterior(null);
        }else{
            fim = null;
        }
        tamanho--;
        return aux;
    }
    
    public void inserirFim(Object info){
        No no = new No();
        no.setInfo(info);
        no.setProximo(null);
        no.setAnterior(fim);
        if(fim != null){
            fim.setProximo(no);
        }
        fim = no;
        if (tamanho == 0){
            inicio = fim;
        }
        tamanho ++;
    }
    
    public Object retirarFim(){
        if(fim==null){
            return null;
        }
        Object aux = fim.getInfo();
        fim = fim.getAnterior();
        if(fim != null){
            fim.setAnterior(null);
        }else{
            inicio = null;
        }
        tamanho--;
        return aux;
    }
    
    public void inserirpos(int pos,Object info){
        if(pos <=0){
            inserirInicio(info);
        }else if(pos>= tamanho){
            inserirFim(info);
        }else{
            No local = inicio;
            for (int i=0; i<pos-1;i++){
                local=local.getProximo();
            }
            No no = new No();
            no.setInfo(info);
            no.setAnterior(local);
            no.setProximo(local.getProximo());
            local.setProximo(no);
            //ENTENDIR ISSO DEPOIS
            //no.proximo.anterior= no;
            no.getProximo().setAnterior(no);
            tamanho++;
        }
    
    }
    
    public Object retirarpos(int pos){
        if(pos<0 || pos>= tamanho || inicio == null){
            return null;
        }else if(pos == 0){
            return retirarInicio();
        }else if(pos == tamanho-1){
            return retirarFim();
        }
        
        No local = inicio;
        for (int i= 0; i< pos;i++){
            local = local.getProximo(); 
        }
        if(local.getAnterior() != null){
            //local.anterior.proximo = local.proximo;
            local.getAnterior().setProximo(local.getProximo());
        }
        if(local.getProximo() != null){
            //local.proximo.anterior = local.anterior;
            local.getProximo().setAnterior(local.getAnterior());
        }
        tamanho--;
        return local.getInfo();
    }
  
    public Object buscar(Object info){
        No atual = inicio;
        if(inicio==null){
            System.out.println("Lista vazia");
            return null;
        }
        
        while(atual != null && info != atual.getInfo()){
            atual=atual.getProximo();
        }
        if(atual==null || info!=atual.getInfo()){
            return null;
        }else{
            return info;
        }      
    }
    
    @Override
    public String toString(){
        String str="";
        No local= inicio;
        while (local!= null){
            str += local.getInfo() + ", ";
            local = local.getProximo();
        }
        return str;
    }
    
    public String imprimir(){
        return toString();
    }

    @Override
    public void adicionar(Object elemento) {
        inserirFim(elemento); 
    }
    
    public void adicionar(Object[] elemento){
        for (Object object : elemento) {
            adicionar(object);
        }
    }
    @Override
    public Object remover(Object elemento) {
        if(tamanho > 0){
            No atual = inicio;
            while(atual != null && !elemento.equals(atual.getInfo())){
                atual=atual.getProximo();
            }
            if(atual != null){
                if(atual.getAnterior() != null){
                    //atual.anterior.proximo = atual.proximo;
                    atual.getAnterior().setProximo(atual.getProximo());
                }
                if(atual.getProximo() != null){
                    //atual.proximo.anterior = atual.anterior;
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                tamanho--;
                return atual.getInfo();
            }
        }
        return null;
    }


    public class No{
    private Object info;
    private No proximo;
    private No anterior;

    public void setInfo(Object info){
        this.info = info;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }

    public Object getInfo(){
        return info;
    }
    public No getProximo(){
        return proximo;
    }
    public No getAnterior(){
        return anterior;
    }

}


}