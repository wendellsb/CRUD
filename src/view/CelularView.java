package view;

import java.util.Scanner;

import controller.CelularController;
import model.Celular;

public class CelularView {
    public void create() {
        Scanner teclado = new Scanner(System.in);
        Celular celular = new Celular();
        CelularController controller = new CelularController();

        System.out.println("Código: ");
        celular.setCodigo(teclado.nextLine());
        System.out.println("Marca: ");
        celular.setMarca(teclado.nextLine());
        System.out.println("Modelo: ");
        celular.setModelo(teclado.nextLine());
        System.out.println("Cor: ");
        celular.setCor(teclado.nextLine());

        controller.create(celular);
    }

    public void read() {
        CelularController controller = new CelularController();

        System.out.println("Listagem de Celulares");

        for (Celular celular : controller.read()) {
            System.out.println(celular);
            System.out.println("Código: " + celular.getCodigo());
            System.out.println("Marca: " + celular.getMarca());
            System.out.println("Modelo: " + celular.getModelo());
            System.out.println("Cor: " + celular.getCor());
        }
    }

    public void update() {
        Scanner teclado = new Scanner(System.in);
        Celular celular = new Celular();
        CelularController controller = new CelularController();

        System.out.println("Código de rastreio: ");
        celular.setCodigo(teclado.nextLine());
        System.out.println("Nova marca: ");
        celular.setMarca(teclado.nextLine());
        System.out.println("Novo modelo: ");
        celular.setModelo(teclado.nextLine());
        System.out.println("Nova cor: ");
        celular.setCor(teclado.nextLine());

        controller.update(celular);
    }

    public void delete() {
        Scanner teclado = new Scanner(System.in);
        String codigo;
        CelularController controller = new CelularController();

        System.out.println("Código de rastreio: ");
        codigo = teclado.nextLine();

        controller.delete(codigo);
    }

    public static void main(String[] args) {
        CelularView telaCelular = new CelularView();

        telaCelular.create();

        telaCelular.read();

        telaCelular.update();

        telaCelular.delete();

    }

}