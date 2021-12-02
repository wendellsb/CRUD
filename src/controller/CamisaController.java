package controller;

import java.util.ArrayList;
import java.util.List;

import dao.CamisaDAO;
import model.Camisa;

public class CamisaController {

    public void create(Camisa camisa) {
        try {
            CamisaDAO dao = new CamisaDAO();
            dao.create(camisa);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Camisa> read() {
        List<Camisa> camisas = new ArrayList<>();

        try {
            CamisaDAO dao = new CamisaDAO();
            camisas = dao.read();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return camisas;
    }

    public void update(Camisa camisa) {
        try {
            CamisaDAO dao = new CamisaDAO();
            dao.update(camisa);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String codigo) {
        try {
            CamisaDAO dao = new CamisaDAO();
            dao.delete(codigo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}