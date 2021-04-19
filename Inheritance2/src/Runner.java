import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {

    private static void printPurchases(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {


        final Product MEAT = new Product("meat", 100);

        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new TransportExpensesPurchase(MEAT, 1, 453),
                new PercentDiscountPurchase(MEAT, 8, 4.12),
                new PriceDiscountPurchase(MEAT, 6, 23),
                new PercentDiscountPurchase(MEAT, 15, 2.56),
                new TransportExpensesPurchase(MEAT, 1, 123),
                new PriceDiscountPurchase(MEAT, 3, 55)
        };

        printPurchases(purchases);

        Arrays.sort(purchases);

        printPurchases(purchases);

        System.out.println("Product with minimum cost = " + purchases[purchases.length - 1] + "\n");

        int index = Arrays.binarySearch(purchases, new TransportExpensesPurchase(
                new Product("",500),1,0));
        System.out.println(index < 0
                ? "Required purchase is not found"
                : "Required purchase is " + purchases[index]);

    }

}