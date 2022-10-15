package ed;

import comum.*;

public class Teste {
    public static void main(String[] args) {
        Arquivo dados = new Arquivo("entrada/dados.txt");
        Arquivo comandos =new Arquivo("entrada/comandos.txt");
        

        ControleDeEstruturas contrEstr = new ControleDeEstruturas();
        
        contrEstr.adicionarParaTodos(dados.lerTudo());

        Object comando[] = comandos.lerTudo();
        for (int i = 0; i < comando.length; i++) {
            contrEstr.tratar(comando[i].toString());
        }
        


    }
}
