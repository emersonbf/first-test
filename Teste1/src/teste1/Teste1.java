package teste1;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Emerson Borges Ferreira
 */

public class Teste1 {
    // Método para ler a idade, e retornar um valor valido ( inteiro )
    public static int lerIdade(final Scanner scanner) {
        for (;;) {
            System.out.printf("Idade: ");
            final String idade = scanner.nextLine();
            try {
                final int idade_int = Integer.parseInt(idade);
                return idade_int;
            } catch (NumberFormatException e) {
                System.out.println("Idade inválido! Tente novamente.");
            }
        }
    }
    
    // Método para ler o Nome, e retornar um nome valido ( somente string )
    public static String lerNome(final Scanner input) {
      for (;;) {
        System.out.printf("Nome: ");
        final String nome = input.nextLine();
            if((!nome.matches("^[A-Za-z ]*$")) || (nome.equals(""))){
                System.out.println("Nome inválido! Tente novamente.");
            } else {
                return nome;   
              }
      }   
   }
   
    // Método para ler a resposta, e retornar um valor valido ( inteiro ) ( mesmo método da idade )
    public static int lerResp(final Scanner scanner) {
        for (;;) {
            System.out.printf("1 - Novo cadastro  / 2 - Sair : ");
            final String resp = scanner.nextLine();
            try {
                final int resp_int = Integer.parseInt(resp);
                return resp_int;
            } catch (NumberFormatException e) {
                System.out.println("Resposta inválida! Tente novamente.");
            }
        }
    } 
       
    public static void main(String[] args) {
        System.out.println("PRIMEIRO TESTE");
        
        int cont = 0, idade, sum_idade=0,resp;
        String nome; 
        
        Scanner input = new Scanner (System.in);
        
        try{
            FileOutputStream arquivo = new FileOutputStream("arquivo.txt"); // Cria o arquivo
            PrintWriter pr = new PrintWriter(arquivo);  // Iniciar a escrita

            do {
                System.out.printf("Cadastro numero: %d \n", cont+1);
                        
                nome = lerNome(input); // Leitura do NOME
                idade = lerIdade(input); // Leitura da IDADE
                resp = lerResp(input); // Leitura da RESPOSTA, Se for 1, continuar cadastrando
            
                cont++;
                sum_idade +=idade; // Somatório das idades informadas
            
                pr.printf(" %s, %d anos;\n", nome, idade); // Escreve o nome e idade no arquivo TXT
            
            }while(resp == 1); // Se valor diferente de 1, sai do laço
            System.out.printf("Idade média é %d anos.\n", sum_idade/cont); // Informa a Média das idades
    
            pr.close(); // Fecha o escritor
            arquivo.close(); // Fecha o arquivo
        }
        catch (Exception e){ // Caso ocora um erro no arquivo (exceção), o usuario é informado
            System.out.println("Erro referente ao arquivo.");
        }
    }
}