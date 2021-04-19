package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase {

    private Byn priceDiscount;

    public PriceDiscountPurchase(Product product, int unitsNumber, int priceDiscount) {
        super(product, unitsNumber);
        this.priceDiscount = new Byn(priceDiscount);
    }

    public Byn getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Byn priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + priceDiscount;
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        return baseCost.subtraction(priceDiscount.multiply(getProductsNumber()));
    }
}