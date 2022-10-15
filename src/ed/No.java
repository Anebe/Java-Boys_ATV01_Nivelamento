
package ed;

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
