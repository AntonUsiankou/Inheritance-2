package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable <AbstractPurchase> {
    private final Product product;
    private int productsNumber ;

    public AbstractPurchase(Product product, int productsNumber ){
        this.product = product;
        this.productsNumber  = productsNumber ;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductsNumber () {
        return productsNumber ;
    }

    public void setProductsNumber (int unitsNumber) {
        this.productsNumber  = unitsNumber;
    }

    protected abstract Byn getCalculateCost (Byn baseCost);

    public Byn getCost (){
        return getCalculateCost(product.getPrice().multiply(productsNumber )).round(RoundMethod.FLOOR, 2);
    }

    protected String fieldsToString() {
        return product+ ";" + productsNumber ;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    public int compareTo(AbstractPurchase purchase){
        return purchase.getCost().compareTo(getCost());
    }
}
