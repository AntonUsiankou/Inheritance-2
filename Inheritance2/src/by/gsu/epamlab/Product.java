package by.gsu.epamlab;

public final class Product{
    final private String productName;
    final private Byn price;

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