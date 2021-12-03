package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Celular;

public class CelularDAO {

    public void create(Celular celular) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "insert into celular(codigo, marca, modelo, cor) values(?, ?, ?, ?)";

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, celular.getCodigo());
            stmt.setString(2, celular.getMarca());
            stmt.setString(3, celular.getModelo());
            stmt.setString(4, celular.getCor());

            stmt.executeUpdate();

            System.out.println("Inserido no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public List<Celular> read() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select codigo, marca, modelo, cor from celular";
        List<Celular> celulares = new ArrayList<Celular>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Celular celular = new Celular();

                celular.setCodigo(rs.getString("codigo"));
                celular.setMarca(rs.getString("marca"));
                celular.setModelo(rs.getString("modelo"));
                celular.setCor(rs.getString("cor"));

                celulares.add(celular);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return celulares;
    }

    public void update(Celular celular) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String linha = celular.getCodigo();

        String sql = String.format("update celular set codigo=?, marca=?, modelo=?, cor=? where codigo=%s",
                linha);

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, celular.getCodigo());
            stmt.setString(2, celular.getMarca());
            stmt.setString(3, celular.getModelo());
            stmt.setString(4, celular.getCor());

            stmt.executeUpdate();

            System.out.println("Celular atualizado no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public void delete(String codigo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "delete from celular where codigo=?";

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, codigo);

            stmt.executeUpdate();

            System.out.println("Celular excluído do banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

}