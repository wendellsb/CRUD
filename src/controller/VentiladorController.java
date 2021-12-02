package controller;

import java.util.ArrayList;
import java.util.List;

import dao.VentiladorDAO;
import model.Ventilador;

public class VentiladorController {

    public void create(Ventilador ventilador) {
        try {
            VentiladorDAO dao = new VentiladorDAO();
            dao.create(ventilador);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ventilador> read() {
        List<Ventilador> ventiladores = new ArrayList<>();

        try {
            VentiladorDAO dao = new VentiladorDAO();
            ventiladores = dao.read();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ventiladores;
    }

    public void update(Ventilador ventilador) {
        try {
            VentiladorDAO dao = new VentiladorDAO();
            dao.update(ventilador);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String codigo) {
        try {
            VentiladorDAO dao = new VentiladorDAO();
            dao.delete(codigo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}