import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Product objProduct = new Product();

        objProduct.setNameClient(JOptionPane.showInputDialog("Insira o Nome do Cliente: "));
        objProduct.setQuantity(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de Energéticos comprados: ")));

        JOptionPane.showMessageDialog(null, objProduct.toString());
    }
}
