package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Ventilador;

public class VentiladorDAO {

    public void create(Ventilador ventilador) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "insert into ventilador(codigo, marca, modelo, cor) values(?, ?, ?, ?)";

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, ventilador.getCodigo());
            stmt.setString(2, ventilador.getMarca());
            stmt.setString(3, ventilador.getModelo());
            stmt.setString(4, ventilador.getCor());

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

    public List<Ventilador> read() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select codigo, marca, modelo, cor from celular";
        List<Ventilador> ventiladores = new ArrayList<Ventilador>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ventilador ventilador = new Ventilador();

                ventilador.setCodigo(rs.getString("codigo"));
                ventilador.setMarca(rs.getString("marca"));
                ventilador.setModelo(rs.getString("modelo"));
                ventilador.setCor(rs.getString("cor"));

                ventiladores.add(ventilador);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return ventiladores;
    }

    public void update(Ventilador ventilador) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String linha = ventilador.getCodigo();

        String sql = String.format("update Ventilador set codigo=?, marca=?, modelo=?, cor=? where codigo=%s",
                linha);

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, ventilador.getCodigo());
            stmt.setString(3, ventilador.getMarca());
            stmt.setString(4, ventilador.getModelo());
            stmt.setString(5, ventilador.getCor());

            stmt.executeUpdate();

            System.out.println("Ventilador atualizado no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public void delete(String codigo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "delete from ventilador where codigo=?";

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);

            stmt.setString(1, codigo);

            stmt.executeUpdate();

            System.out.println("Ventilador excluído do banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

}