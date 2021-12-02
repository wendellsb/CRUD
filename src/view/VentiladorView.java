package view;

import java.util.Scanner;

import controller.VentiladorController;
import model.Ventilador;

public class VentiladorView {
    public void create() {
        Scanner teclado = new Scanner(System.in);
        Ventilador ventilador = new Ventilador();
        VentiladorController controller = new VentiladorController();

        System.out.println("Código: ");
        ventilador.setCodigo(teclado.nextLine());
        System.out.println("Marca: ");
        ventilador.setMarca(teclado.nextLine());
        System.out.println("Modelo: ");
        ventilador.setModelo(teclado.nextLine());
        System.out.println("Cor: ");
        ventilador.setCor(teclado.nextLine());

        controller.create(ventilador);
    }

    public void read() {
        VentiladorController controller = new VentiladorController();

        System.out.println("Listagem de Ventiladores");

        for (Ventilador ventilador : controller.read()) {
            System.out.println(ventilador);
            System.out.println("Código: " + ventilador.getCodigo());
            System.out.println("Marca: " + ventilador.getMarca());
            System.out.println("Modelo: " + ventilador.getModelo());
            System.out.println("Cor: " + ventilador.getCor());
        }
    }

    public void update() {
        Scanner teclado = new Scanner(System.in);
        Ventilador ventilador = new Ventilador();
        VentiladorController controller = new VentiladorController();

        System.out.println("Código de rastreio: ");
        ventilador.setCodigo(teclado.nextLine());
        System.out.println("Nova marca: ");
        ventilador.setMarca(teclado.nextLine());
        System.out.println("Novo modelo: ");
        ventilador.setModelo(teclado.nextLine());
        System.out.println("Nova cor: ");
        ventilador.setCor(teclado.nextLine());

        controller.update(ventilador);
    }

    public void delete() {
        Scanner teclado = new Scanner(System.in);
        String codigo;
        VentiladorController controller = new VentiladorController();

        System.out.println("Código de rastreio: ");
        codigo = teclado.nextLine();

        controller.delete(codigo);
    }

    public static void main(String[] args) {
        VentiladorView telaVentilador = new VentiladorView();

        telaVentilador.create();

        telaVentilador.read();

        telaVentilador.update();

        telaVentilador.delete();

    }

}