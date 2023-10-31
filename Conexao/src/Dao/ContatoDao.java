package src.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.Conexao.ConexaoTeste;

import src.Conexao.Conexao;
import src.Modelo.Contato;

public class ContatoDao {
    private Connection connection;

    public ContatoDao() {
        this.connection = new ConexaoTeste().getConnection();
    }

    public void adiciona(Contato contato){
        String sql = "insert into contatos (codigo, nome) values (?,?)";

        try {
            // prepared statement para insercao
            PreparedStatement stat = connection.prepareStatement(sql);

            //Seta os valor
           stat.setLong(1,contato.getCodigo());
           stat.setString(2, contato.getNome());

           // Executa
           stat.execute();
           stat.close();
        }catch (SQLException e){
            System.out.println("Deu erro!!");
        }
    }
}
