package src.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoTeste {
    public Connection getConnection(){
         try {
             return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Java_SQL",
                     "postgres", "ifg");
         }catch (SQLException e){
             throw new RuntimeException(e);
         }
    }
}
