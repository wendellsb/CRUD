package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Camisa;

public class CamisaDAO {

    public void create(Camisa camisa) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "insert into camisa(codigo, marca, modelo, cor) values(?, ?, ?, ?)";

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, camisa.getCodigo());
            stmt.setString(2, camisa.getMarca());
            stmt.setString(3, camisa.getModelo());
            stmt.setString(4, camisa.getCor());

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

    public List<Camisa> read() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select codigo, marca, modelo, cor from camisa";
        List<Camisa> camisas = new ArrayList<Camisa>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Camisa camisa = new Camisa();

                camisa.setCodigo(rs.getString("codigo"));
                camisa.setMarca(rs.getString("marca"));
                camisa.setModelo(rs.getString("modelo"));
                camisa.setCor(rs.getString("cor"));

                camisas.add(camisa);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return camisas;
    }

    public void update(Camisa camisa) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String linha = camisa.getCodigo();

        String sql = String.format("update Camisa set codigo=?, marca=?, modelo=?, cor=? where codigo=%s",
                linha);

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, camisa.getCodigo());
            stmt.setString(3, camisa.getMarca());
            stmt.setString(4, camisa.getModelo());
            stmt.setString(5, camisa.getCor());

            stmt.executeUpdate();

            System.out.println("Camisa atualizada no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public void delete(String codigo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "delete from camisa where codigo=?";

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, codigo);

            stmt.executeUpdate();

            System.out.println("Camisa excluída do banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

}