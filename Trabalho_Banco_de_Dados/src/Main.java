import Conexao.Conexao;
import Dao.AeroportoDao;
import Modelo.Aeroporto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean repetir = true;

        while (repetir){
            System.out.println("\nDigite uma das opcao abaixo: \n"+
                    "1 - Adicionar Aeroporto \n" +
                    "2 - Alterar Aeroporto\n" +
                    "3 - Remover Aeroporto\n" +
                    "4 - Listar Aeroporto \n" +
                    "5 - Fechar o Programa\n");

            System.out.println("\nEntre com a opcao desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                        adicionarAeroporto();
                    break;

                    case 2:
                        alterarAeroporto();
                    break;

                    case 3:
                        excluirAeroporto();
                        break;

                case 4:
                        listarAeroporto();
                    break;

                case 5: // Fechando o programa
                    repetir = false;
                    break;

                default: // Ficar avisando o programa que nao acho alguma opcao
                    System.out.println("\nOpcao Invalida!\n");
            }
        }

        Conexao com = new Conexao();

    }
    public static void listarAeroporto(){

        AeroportoDao dao = new AeroportoDao();
        List<Aeroporto> aeroporto = dao.getList();

        for (Aeroporto com: aeroporto){
            System.out.println("");
            System.out.println(com.getCodigo());
            System.out.println(com.getNome());
            System.out.println(com.getLocalizacao());

        }
    }

    public static void adicionarAeroporto(){
        // Modulo Contato
        Scanner scanner = new Scanner(System.in);

        Aeroporto aeroporto = new Aeroporto();

        System.out.println("");

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

        System.out.println("");

        System.out.println("Informe um codigo:");
        aeroporto.setCodigo(scanner.nextInt());

        System.out.println("Informe um Nome:");
        aeroporto.setNome(scanner.next());

        System.out.println("Informe um Localizacao:");
        aeroporto.setLocalizacao(scanner.next());

        AeroportoDao dao = new AeroportoDao();
        dao.alterar(aeroporto);

    }
    public static void excluirAeroporto(){


        Scanner scanner = new Scanner(System.in);

        Aeroporto aeroporto = new Aeroporto();

        System.out.println("");
        System.out.println("Informe um codigo:");
        aeroporto.setCodigo(scanner.nextInt());

        AeroportoDao dao = new AeroportoDao();
        dao.excluir(aeroporto);

    }
}