import Conexao.Conexao;
import Dao.AeroportoDao;
import Modelo.Aeroporto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("Digite uma das opcao abaixo: \n"+
                "1 - Adicionar Aeroporto \n" +
                "2 - Remover Aeroporto \n" +
                "3 - Alterar Aeroporto \n" +
                "4 - Listar Aeroporto \n");

        opcao = scanner.nextInt();
        if (opcao == 1){
            adicionarAeroporto();
        } else if (opcao == 2) {
            excluirAeroporto();
        } else if (opcao == 3) {
            alterarAeroporto();
        } else if (opcao == 4) {
            ListarContato();
        }else {
            System.out.println("Opcao Invalida \n");
        }
        Conexao com = new Conexao();

    }
    public static void ListarContato(){

        AeroportoDao dao = new AeroportoDao();
        List<Aeroporto> aeroporto = dao.getList();

        for (Aeroporto com: aeroporto){
            System.out.println(com.getCodigo());
            System.out.println(" ");
            System.out.println(com.getNome());
            System.out.println(" ");
            System.out.println(com.getLocalizacao());
        }
    }

    public static void adicionarAeroporto(){
        // Modulo Contato
        Scanner scanner = new Scanner(System.in);

        Aeroporto aeroporto = new Aeroporto();

        System.out.println("Informe um codigo:");
        aeroporto.setCodigo(scanner.nextInt());

        System.out.println("Informe um Nome:");
        aeroporto.setNome(scanner.next());

        System.out.println("Informe um Localizacao:");
        aeroporto.setLocalizacao(scanner.next());

        AeroportoDao dao = new AeroportoDao();
        dao.adiciona(aeroporto);
        System.out.println("Gravado");
    }


    public static void alterarAeroporto(){
        // Modulo Contato

        Scanner scanner = new Scanner(System.in);

        Aeroporto aeroporto = new Aeroporto();

        System.out.println("Informe um codigo:");
        aeroporto.setCodigo(scanner.nextInt());

        System.out.println("Informe um Nome:");
        aeroporto.setNome(scanner.next());

        System.out.println("Informe um codigo:");
        aeroporto.setLocalizacao(scanner.next());

        AeroportoDao dao = new AeroportoDao();
        dao.alterar(aeroporto);

    }
    public static void excluirAeroporto(){
        // Modulo Contato

        Scanner scanner = new Scanner(System.in);

        Aeroporto aeroporto = new Aeroporto();

        System.out.println("Informe um codigo:");
        aeroporto.setCodigo(scanner.nextInt());

        AeroportoDao dao = new AeroportoDao();
        dao.excluir(aeroporto);

    }
}