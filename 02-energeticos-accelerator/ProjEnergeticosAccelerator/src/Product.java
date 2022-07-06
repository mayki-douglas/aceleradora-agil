import java.text.NumberFormat;
import java.util.Locale;

public class Product {

    private String nameClient;
    private int quantity;
    private static final float unitaryValue = 4.50f;
    private static final float icms = 0.18f;
    private static final float ipi = 0.04f;
    private static final float pis = 0.0186f;
    private static final float cofins = 0.0854f;

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float calculatePriceAndQuantity(){
        return quantity * unitaryValue;
    }

    public float calculateIcms(){
        return calculatePriceAndQuantity() * icms;
    }

    public float calculateIpi(){
        return calculatePriceAndQuantity() * ipi;
    }

    public float calculatePis(){
        return calculatePriceAndQuantity() * pis;
    }

    public float calculateCofins(){
        return calculatePriceAndQuantity() * cofins;
    }

    public float sumTaxes(){
        return calculateIcms() + calculateIpi() + calculatePis() + calculateCofins();
    }

    public float calculateTotalValue(){
        return (unitaryValue * quantity) + sumTaxes();
    }

    @Override
    public String toString() {
        return "Dados do Cliente: "+"\n" +
                "Nome: "+this.nameClient+"\n" +
                "Quantidade comprada: "+this.quantity+"\n" +
                "Valor dos Produtos: "+this.calculatePriceAndQuantity()+"\n" +
                "Total de Impostos: "+this.sumTaxes()+"\n" +
                "TOTAL: "+this.calculateTotalValue();
    }
}
