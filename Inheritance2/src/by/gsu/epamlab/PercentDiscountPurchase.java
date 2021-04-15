package by.gsu.epamlab;

public class PercentDiscountPurchase extends AbstractPurchase {
    private double percentDiscount;
    private static final int MIN_NUMBER_DISCOUNT = 10;

    public PercentDiscountPurchase() {
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public PercentDiscountPurchase(Product product, int unitsNumber, double percentDiscount) {
        super(product, unitsNumber);
        this.percentDiscount = percentDiscount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percentDiscount;
    }

    @Override
    protected Byn calculateCost(Byn baseCost){
        if(getUnitsNumber() > MIN_NUMBER_DISCOUNT){
            baseCost.multiply(1.0 - percentDiscount / 100.0);
        }
        return baseCost;
    }
}
