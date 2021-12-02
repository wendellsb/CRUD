package view;

import java.util.Scanner;

import controller.CamisaController;
import model.Camisa;

public class CamisaView {
    public void create() {
        Scanner teclado = new Scanner(System.in);
        Camisa camisa = new Camisa();
        CamisaController controller = new CamisaController();

        System.out.println("Código: ");
        camisa.setCodigo(teclado.nextLine());
        System.out.println("Marca: ");
        camisa.setMarca(teclado.nextLine());
        System.out.println("Modelo: ");
        camisa.setModelo(teclado.nextLine());
        System.out.println("Cor: ");
        camisa.setCor(teclado.nextLine());

        controller.create(camisa);
    }

    public void read() {
        CamisaController controller = new CamisaController();

        System.out.println("Listagem de Camisas");

        for (Camisa camisa : controller.read()) {
            System.out.println(camisa);
            System.out.println("Código: " + camisa.getCodigo());
            System.out.println("Marca: " + camisa.getMarca());
            System.out.println("Modelo: " + camisa.getModelo());
            System.out.println("Cor: " + camisa.getCor());
        }
    }

    public void update() {
        Scanner teclado = new Scanner(System.in);
        Camisa camisa = new Camisa();
        CamisaController controller = new CamisaController();

        System.out.println("Código de rastreio: ");
        camisa.setCodigo(teclado.nextLine());
        System.out.println("Nova marca: ");
        camisa.setMarca(teclado.nextLine());
        System.out.println("Novo modelo: ");
        camisa.setModelo(teclado.nextLine());
        System.out.println("Nova cor: ");
        camisa.setCor(teclado.nextLine());

        controller.update(camisa);
    }

    public void delete() {
        Scanner teclado = new Scanner(System.in);
        String codigo;
        CamisaController controller = new CamisaController();

        System.out.println("Código de rastreio: ");
        codigo = teclado.nextLine();

        controller.delete(codigo);
    }

    public static void main(String[] args) {
        CamisaView telaCamisa = new CamisaView();

        telaCamisa.create();

        telaCamisa.read();

        telaCamisa.update();

        telaCamisa.delete();

    }

}