package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable <AbstractPurchase> {
    private final Product product;
    private int unitsNumber;

    public AbstractPurchase(){
        product = null;
    }

    public AbstractPurchase(Product product, int unitsNumber){
        this.product = product;
        this.unitsNumber = unitsNumber;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    public void setUnitsNumber(int unitsNumber) {
        this.unitsNumber = unitsNumber;
    }

    protected abstract Byn calculateCost (Byn baseCost);

    public Byn getCost (){
        return calculateCost(product.getPrice().multiply(unitsNumber)).round(RoundMethod.FLOOR, 2);
    }

    protected String fieldsToString() {
        return product+ ";" + unitsNumber;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    public int compareTo(AbstractPurchase purchase){
        return purchase.getCost().compareTo(getCost());
    }
}
