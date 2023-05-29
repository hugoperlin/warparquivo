
public class TesteLeitura {
    
    public static void leituraLinha(){
        boolean retorno = Arquivo.abrirLeitura("arquivoteste.txt");

        assert(retorno == true);

        String linha = Arquivo.lerLinha();

        assert(linha.equals("Esta é uma linha"));

        linha = Arquivo.lerLinha();

        assert(linha.equals("Esta é uma outra linha"));

        retorno = Arquivo.fecharLeitura();

        assert(retorno == true);
    }

    public static void leituraLinhas(){
        boolean retorno = Arquivo.abrirLeitura("arquivoteste.txt");

        assert(retorno == true);

        String[] linhas = Arquivo.lerLinhas();

        assert(linhas.length == 2);

        assert(linhas[0].equals("Esta é uma linha"));
        assert(linhas[1].equals("Esta é uma outra linha"));

        retorno = Arquivo.fecharLeitura();

        assert(retorno == true);
    }
    
    public static void main(String[] args) {
        
        leituraLinha();
        leituraLinhas();

    }
}
