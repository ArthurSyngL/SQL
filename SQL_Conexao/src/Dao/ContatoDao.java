package src.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public List<Contato> getList(){
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            String sql = "select * from contatos";
            PreparedStatement stat = this.connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){

                //criando o objeto contato

                Contato contato = new Contato();
                contato.setCodigo(rs.getInt("codigo"));
                contato.setNome(rs.getString("Nome"));

                contatos.add(contato);
            }

            rs.close();
            stat.close();
            return contatos;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void alterar(Contato contato){
        String sql = "uptade contatos set nome=? where codigo=?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setString(1, contato.getNome());
            stat.setLong(2, contato.getCodigo());

            stat.execute();
            stat.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void excluir(Contato contato){
        String sql = "delete from contatos where id=?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setLong(1, contato.getCodigo());

            stat.execute();
            stat.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
