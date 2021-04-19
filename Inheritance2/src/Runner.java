import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {

    private static void printPurchases(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
        System.out.println("-----------------------------------");
    }

    private static void purchaseWithCost(AbstractPurchase[] purchases) {
        int index = Arrays.binarySearch(purchases, new TransportExpensesPurchase(
                new Product(null,new Byn(500)),1,0));
        System.out.println(index < 0
                ? "Required purchase is not found"
                : "Required purchase is " + purchases[index]);
    }

    public static void main(String[] args) {

        // unique product;
        final Product MEAT = new Product("meat", new Byn(100));

        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new TransportExpensesPurchase(MEAT, 1, 453),
                new PercentDiscountPurchase(MEAT, 8, 4.12),
                new PriceDiscountPurchase(MEAT, 6, 23),
                new PercentDiscountPurchase(MEAT, 15, 2.56),
                new TransportExpensesPurchase(MEAT, 1, 123),
                new PriceDiscountPurchase(MEAT, 3, 55)
        };

        // 3. Print the array content to the console
        printPurchases(purchases);

        //4. Sort an array by the cost in descending order with the method sort( ) of the class Arrays.
        Arrays.sort(purchases);

        //5. Print the array content to the console (one element per line).
        printPurchases(purchases);

        //6. Print the minimum cost of purchase.
        System.out.println("Product with minimum cost = " + purchases[purchases.length - 1] + "\n");


        //7. Find some purchase with cost equal to 5.00 BYN with the method binarySearch( ) of the class Arrays and print it.
        purchaseWithCost(purchases);


        //Bonus task №8: All purchases with cost 5.00
        AbstractPurchase purchase = new AbstractPurchase(null, 1) {
            @Override
            protected Byn getFinalCost(Byn cost) {
                throw new UnsupportedOperationException();
            }
            @Override
            public Byn getCost() {
                return new Byn(501);
            }
        };
        int index = -(Arrays.binarySearch(purchases, purchase) + 1);
        if (index < purchases.length
                && purchases[index].getCost().compareTo(new Byn(500)) == 0) {
            System.out.println("All purchases with cost 5.00");
            do {
                System.out.println(purchases[index++]);
            } while (index < purchases.length
                    && purchases[index].getCost().compareTo(new Byn(500)) == 0);
        } else {
            System.out.println("No purchases with price 5.00");
        }

    }

}
