package by.gsu.epamlab;

public class TransportExpensesPurchase extends AbstractPurchase {
    private Byn transportExpenses;

    public TransportExpensesPurchase(Product product, int unitsNumber, int  transportExpenses) {
        super(product, unitsNumber);
        this.transportExpenses = new Byn(transportExpenses);
    }

    public Byn getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(Byn transportExpenses) {
        this.transportExpenses = transportExpenses;
    }
    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        return baseCost.addition(transportExpenses);
    }

}
