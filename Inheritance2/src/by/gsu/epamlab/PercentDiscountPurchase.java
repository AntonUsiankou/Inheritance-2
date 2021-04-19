package by.gsu.epamlab;

public class PercentDiscountPurchase extends AbstractPurchase {

    private double percentDiscount;
    private static final int MIN_NUMBER_DISCOUNT = 10;

    public PercentDiscountPurchase(Product product, int unitsNumber, double percentDiscount) {
        super(product, unitsNumber);
        this.percentDiscount = percentDiscount;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }


    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percentDiscount;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        if (getProductsNumber() >= MIN_NUMBER_DISCOUNT) {
            baseCost = baseCost.multiply(1 - percentDiscount / 100, RoundMethod.ROUND, 0);
        }
        return baseCost;
    }
}
