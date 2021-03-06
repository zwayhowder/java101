import java.util.*;

public class ProductLine
{
    private String productCode; // Format X9999
    private double recRetPrice;
    private double salePrice;
    private int quantity;

    public ProductLine(String productCode, double recRetPrice, double salePrice, int quantity) {
      this.productCode = productCode;
      this.recRetPrice = recRetPrice;
      this.salePrice = salePrice;
      this.quantity = quantity;
    }

    public void setquantity(int num){
      quantity = num;
    }

    public void setrecRetPrice(double num){
      recRetPrice = num;
    }

    public void setsalePrice(double num){
      salePrice = num;
    }

    public void setproductCode(String code){
      productCode = code;
    }

    public String getProductCode(){
      return productCode;
    }

    public double getSalePrice(){
      return salePrice;
    }

    public double getRecRetPrice(){
      return recRetPrice;
    }

    public int getQuantity(){
      return quantity;
    }

    public void sell(int no) {
      setquantity(quantity - no);
    }

}

