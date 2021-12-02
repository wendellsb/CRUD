package controller;

import java.util.ArrayList;
import java.util.List;

import dao.CelularDAO;
import model.Celular;

public class CelularController {

    public void create(Celular celular) {
        try {
            CelularDAO dao = new CelularDAO();
            dao.create(celular);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Celular> read() {
        List<Celular> celulares = new ArrayList<>();

        try {
            CelularDAO dao = new CelularDAO();
            celulares = dao.read();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return celulares;
    }

    public void update(Celular celular) {
        try {
            CelularDAO dao = new CelularDAO();
            dao.update(celular);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String codigo) {
        try {
            CelularDAO dao = new CelularDAO();
            dao.delete(codigo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}