package src;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conecao{
    private String url;
    private String usuario;
    private String senha;

    private Connection com;

public Conecao() {
    url = "jdbc:postgresql://localhost:5432/Java_SQL";
    usuario = "postgres";
    senha = "ifg";


        try {
            Class.forName("org.postgresql.Driver");
            com = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Concecao Realizada com sucesso");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


