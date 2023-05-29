
public class TesteEscrita {
    

    public static void main(String[] args) {
        
        boolean retorno = Arquivo.abrirEscrita("arquivoteste.txt");

        assert(retorno == true);

        retorno = Arquivo.escrever("Esta é uma linha.");

        assert(retorno == true);

        retorno = Arquivo.novaLinha();

        assert(retorno == true);

        retorno = Arquivo.escrever("Esta é outra uma linha.");

        assert(retorno == true);

        retorno = Arquivo.fecharEscrita();

        assert(retorno == true);



    }
}
