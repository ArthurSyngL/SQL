package src;

import src.Conexao.Conexao;
import src.Dao.ContatoDao;
import src.Modelo.Contato;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("Digite uma das opcao abaixo: \n"+
                "1 - Adicionar Contato \n" +
                "2 - Remover Contato \n" +
                "3 - Alterar Contato \n" +
                "4 - Listar Contatos \n");

        opcao = scanner.nextInt();
        if (opcao == 1){
            adicionarContato();
        } else if (opcao == 2) {

        } else if (opcao == 3) {

        } else if (opcao == 4) {
           ListarContato();
        }else {
            System.out.println("Opcao Invalida \n");
        }
        Conexao com = new Conexao();

    }
    public static void ListarContato(){

        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getList();

        for (Contato com: contatos){
            System.out.println(com.getCodigo());
            System.out.println(" ");
            System.out.println(com.getNome());
        }
    }

    public static void adicionarContato(){
        // Modulo Contato
        Scanner scanner = new Scanner(System.in);

        Contato contato = new Contato();

        System.out.println("Informe um codigo:");
        contato.setCodigo(scanner.nextInt());

        System.out.println("Informe um Nome:");
        contato.setNome(scanner.next());

        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        System.out.println("Gravado");
    }
}


