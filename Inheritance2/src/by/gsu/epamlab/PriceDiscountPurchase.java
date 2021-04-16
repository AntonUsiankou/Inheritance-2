package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase {

    private Byn priceDiscount;

    public PriceDiscountPurchase(Product product, int unitsNumber, int priceDiscount) {
        super(product, unitsNumber);
        this.priceDiscount = new Byn(priceDiscount);
    }

    public Byn getKopeckDiscount() {
        return priceDiscount;
    }

    public void setKopeckDiscount(Byn kopeckDiscount) {
        this.priceDiscount = kopeckDiscount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + priceDiscount;
    }

    @Override
    public Byn getCalculateCost(Byn baseCost) {
        return baseCost.subtraction(priceDiscount.multiply(getProductsNumber()));
    }
}