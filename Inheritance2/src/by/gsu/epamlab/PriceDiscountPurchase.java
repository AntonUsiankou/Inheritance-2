package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase {

    private Byn kopeckDiscount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(Product product, int unitsNumber, int kopeckDiscount) {
        super(product, unitsNumber);
        this.kopeckDiscount = new Byn(kopeckDiscount);
    }

    public Byn getKopeckDiscount() {
        return kopeckDiscount;
    }

    public void setKopeckDiscount(Byn kopeckDiscount) {
        this.kopeckDiscount = kopeckDiscount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + kopeckDiscount;
    }

    @Override
    public Byn calculateCost(Byn baseCost) {
        return baseCost.subtraction(kopeckDiscount.multiply(getUnitsNumber()));
    }
}