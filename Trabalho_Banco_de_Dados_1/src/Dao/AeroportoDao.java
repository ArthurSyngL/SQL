package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;

import Modelo.Aeroporto;

public class AeroportoDao {
    private Connection connection;

    public AeroportoDao() {
        this.connection = new Conexao().getConnection();
    }

    public void adiciona(Aeroporto aeroporto){
        String sql = "insert into aeroporto (codigo, nome, localizacao) values (?,?,?)";

        try {
            // prepared statement para insercao
            PreparedStatement stat = connection.prepareStatement(sql);

            //Seta os valor
            stat.setLong(1,aeroporto.getCodigo());
            stat.setString(2, aeroporto.getNome());
            stat.setString(3, aeroporto.getLocalizacao());

            // Executa
            stat.execute();
            stat.close();
        }catch (SQLException e){
            System.out.println("Deu erro!!");
        }
    }

    public List<Aeroporto> getList(){
        try {
            List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();
            String sql = "select * from aeroporto";
            PreparedStatement stat = this.connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){

                //criando o objeto contato

                Aeroporto aeroporto = new Aeroporto();
                aeroporto.setCodigo(rs.getInt("codigo"));
                aeroporto.setNome(rs.getString("Nome"));
                aeroporto.setLocalizacao(rs.getString("Localizacao"));


                aeroportos.add(aeroporto);
            }

            rs.close();
            stat.close();
            return aeroportos;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void alterar(Aeroporto aeroporto){
        String sql = "uptade aeroporto set nome=? where codigo=? and localizacao = ?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setLong(1, aeroporto.getCodigo());
            stat.setString(2, aeroporto.getNome());
            stat.setString(3, aeroporto.getLocalizacao());

            stat.execute();
            stat.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void excluir(Aeroporto aeroporto){
        String sql = "delete from aeroporto where codigo=?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setLong(1, aeroporto.getCodigo());

            stat.execute();
            stat.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
