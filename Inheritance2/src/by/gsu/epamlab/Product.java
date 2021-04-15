package by.gsu.epamlab;

public class Product{
    final private String productName;
    final private Byn price;

    public Product(){
        productName = null;
        price = null;
    }

    public Product(String productName, Byn productPrice){
        this.productName = productName;
        this.price = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return productName + ";" + price;
    }

}