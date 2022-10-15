package comum;

import java.util.StringTokenizer;

import ed.*;

public class ControleDeEstruturas {
    private StringTokenizer comando;
    private ArvoreBinaria arvBin;
    private Pilha pilha;
    private Fila fila;
    private Lista_Dupla listD;

    public ControleDeEstruturas(){
        arvBin = new ArvoreBinaria();
        pilha = new Pilha();
        fila = new Fila();
        listD = new Lista_Dupla();
    }

    public void tratar(String comando){
        EstruturaDeDado estrDado = null;

        this.comando = new StringTokenizer(comando, " ");
        String estrutura = this.comando.nextToken().toLowerCase();
        String metodo = this.comando.nextToken().toLowerCase();

        //Escolher estrutura
        if(estrutura.equals("pilha")){
            estrDado = pilha;
        }
        else if(estrutura.equals("arvore_binaria")){
            estrDado = arvBin;
        }
        else if(estrutura.equals("fila")){
            estrDado = fila;
        }
        else if(estrutura.equals("lista")){
            estrDado = listD;
        }else{
            System.out.println("Estrutura inválida.");
        }

        if(estrDado != null){
            System.out.print(estrDado.getClass().getSimpleName() + ": ");

            //Escolher método
            if(metodo.equals("adicionar")){
                if(this.comando.hasMoreElements()){
                    if(estrDado.getClass() != listD.getClass()){
                        Object dado = this.comando.nextToken("\n").substring(1);
                        estrDado.adicionar(dado);
                        System.out.println(dado + " adicionado");
                    }
                    else{
                        int index = Integer.parseInt(this.comando.nextElement().toString());
                        Object dado = this.comando.nextToken("\n").substring(1);
                        listD.inserirpos(index, dado);
                        System.out.println(dado + " adicionado");
                    }
                    
                }else{
                    System.out.println("Dado inválido");
                }
                
            }
            else if(metodo.equals("remover")){
                if(this.comando.hasMoreElements()){
                    Object dado = this.comando.nextToken("\n").substring(1);
                    System.out.println(estrDado.remover(dado) + " removido");
                }
                else if(estrDado.getClass() == pilha.getClass()){
                    System.out.println(pilha.remover() + " removido");
                }
                else if(estrDado.getClass() == fila.getClass()){
                    System.out.println(fila.remover() + " removido");
                }
                else{
                    System.out.println("Comando inválido");
                }
                
            }
            else if(metodo.equals("imprimir")){
                if(estrDado.getClass() == arvBin.getClass()){
                    if(this.comando.hasMoreTokens()){
                        Object dado = this.comando.nextToken("\n").substring(1);
                        if(dado.equals("ordem")){
                            System.out.println("Ordem: " + arvBin.ordem());
                        }else if(dado.equals("pre-ordem")){
                            System.out.println("Pré-Ordem: " + arvBin.preOrdem());
                        }else if(dado.equals("pos-ordem")){
                            System.out.println("Pós-Ordem: " + arvBin.posOrdem());
                        }
                    }
                    else{
                        System.out.println("Falta argumento");
                    }
                    
                }else{
                    System.out.println(estrDado.imprimir());
                }
            }
            else if(metodo.equals("buscar")){
                if(this.comando.hasMoreElements()){
                    Object dado = this.comando.nextToken("\n").substring(1);
    
                    if(estrDado.buscar(dado) == null){
                        System.out.println(dado + " não foi encontrado");
                    }
                    else{
                        System.out.println(dado + " foi encontrado");
                    }
                }else{
                    System.out.println("Dado inválido");
                }
                
            }
            else{
                System.out.println("Método inválido.");
            }
        
        }
    }

    public void adicionarParaTodos(Object[] dados){
        if(dados != null){
            arvBin.adicionar(dados);
            pilha.adicionar(dados);
            fila.adicionar(dados);
            listD.adicionar(dados);
        }
        
    }
}
