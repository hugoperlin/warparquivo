import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/***
 * Classe que facilita utilizar arquivos texto em Java. Através de métodos
 * estáticos permite, criar, abrir, ler e escrever dados codificados como 
 * texto em arquivos. 
 */


public class Arquivo {
    
    private static String nomeArquivo;
    
    private static FileReader fr;
    private static BufferedReader br;
    
    private static FileWriter fw;
    private static BufferedWriter bw;

    /**
     * Abre o arquivo em texto para leitura. Deve ser invocado antes de realizar
     * a leitura de dados do arquivo.
     * Deve ser chamado somente uma vez. Importante invocar o método fecharLeitura 
     * finalizar a leitura do arquivo.
     * Se o arquivo já estiver aberto ou não existir uma mensagem de erro será impressa
     * na tela e o método retornará false.
     * 
     * @param nomeArquivo nome do arquivo. 
     * @return true se arquivo aberto, false caso contrário. Em caso de erro, uma
     * mensagem é impressa na tela.
     */
    public static boolean abrirLeitura(String nome){
        if(fr != null || fw != null){
            System.out.println("ERRO - recurso aberto! Precisa fechar antes!");
            return false;
        }
        
        try{
            nomeArquivo = nome;
            fr = new FileReader(nomeArquivo);
            br = new BufferedReader(fr);
            return true;
        }catch(IOException e){
            System.out.println("ERRO - "+e.getMessage());
            return false;
        }
    }

    /**
     * Abre o arquivo em texto para escrita. Se o arquivo não existir, um
     * novo é criado. Se o arquivo já existir, seu conteúdo será sobrescrito.
     * Deve ser invocado antes de realizar a escrita de dados do arquivo.
     * Deve ser chamado somente uma vez. Importante invocar o método fecharEscrita 
     * finalizar a escrita no arquivo.
     * 
     * Se o arquivo já estiver aberto ou não for possível criar uma mensagem de erro será impressa
     * na tela e o método retornará false.
     * 
     * @param nomeArquivo nome do arquivo. 
     * @return true se arquivo aberto, false caso contrário. Em caso de erro, uma
     * mensagem é impressa na tela.
     */

    public static boolean abrirEscrita(String nome){
        if(fr != null || fw != null){
            System.out.println("ERRO - recurso aberto! Precisa fechar antes!");
            return false;
        }
        
        try{
            nomeArquivo = nome;
            fw = new FileWriter(nomeArquivo);
            bw = new BufferedWriter(fw);
            return true;
        }catch(IOException e){
            System.out.println("ERRO - "+e.getMessage());
            return false;
        }
    }

    /**
     * Escre um texto no arquivo. Deve ser chamado após a abrir para escrita, através
     * do método abrirEscrita.
     * 
     * @param texto Texto a ser escrito no arquivo
     * @return true se possível escrever, false caso contrário. 
     */

    public static boolean escrever(String texto){
        if(fw == null){
            System.out.println("ERRO - Precisa abrir antes!");
            return false;
        }
        try{
            bw.write(texto);
            bw.flush();
            return true;
        }catch(IOException e){
            System.out.println("ERRO - "+e.getMessage());
            return false;
        }
    }

    /**
     * Insere o caractere de nova linha no arquivo. Deve ser chamado após a abrir para escrita, através
     * do método abrirEscrita.
     * 
     * @return true se possível escrever, false caso contrário. 
     */
    
    public static boolean novaLinha(){
        if(fw == null){
            System.out.println("ERRO - Precisa abrir antes!");
            return false;
        }
        try{
            bw.newLine();
            return true;
        }catch(IOException e){
            System.out.println("ERRO - "+e.getMessage());
            return false;
        }
    }

     /**
     * Lê uma linha do arquivo. Deve ser chamado após a abrir para leitura, através
     * do método abrirLeitura.
     * 
     * @return String contendo a linha lida do arquivo. Retornará null se não houver mais linhas. 
     */

    public static String lerLinha(){
        if(fr == null){
            System.out.println("ERRO - Precisa abrir antes!");
            return null;
        }
        try{
            return br.readLine();
        }catch(IOException e){
            System.out.println("ERRO - "+e.getMessage());
            return null;
        }
    }

     /**
     * Lê todas as linhas do arquivo. Deve ser chamado após a abrir para leitura, através
     * do método abrirLeitura.
     * 
     * @return vetor de Strings contendo todas as linhas do arquivo. Retornará null se não houver mais linhas. 
     */

     public static String[] lerLinhas(){
        if(fr == null){
            System.out.println("ERRO - Precisa abrir antes!");
            return null;
        }
        try{
            return br.lines().toArray(String[]::new);
        }catch(Exception e){
            System.out.println("ERRO - "+e.getMessage());
            return null;
        }
    }


        /**
     * Fecha o arquivo para leitura. 
     * 
     * @return true se possível fechar, false caso contrário. Em caso de erro, uma mensagem
     * será impressa na tela.
     */
    public static boolean fecharLeitura(){
        if(fr == null){
            System.out.println("ERRO - Já está fechado!");
            return false;
        }
        try{
            br.close();
            fr.close();
            br = null;
            fr = null;
            return true;
        }catch(IOException e){
            System.out.println("ERRO - "+e.getMessage());
            return false;
        }
    }

    /**
     * Fecha o arquivo para escrita. 
     * 
     * @return true se possível fechar, false caso contrário. Em caso de erro, uma mensagem
     * será impressa na tela.
     */

    public static boolean fecharEscrita(){
        if(fw == null){
            System.out.println("ERRO - Já está fechado!");
            return false;
        }
        try{
            bw.close();
            fw.close();
            bw = null;
            fw = null;
            return true;
        }catch(IOException e){
            System.out.println("ERRO - "+e.getMessage());
            return false;
        }
    }



}
