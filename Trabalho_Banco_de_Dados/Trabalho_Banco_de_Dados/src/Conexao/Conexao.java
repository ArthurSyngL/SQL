package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aeroporto",
                    "postgres", "ifg");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

