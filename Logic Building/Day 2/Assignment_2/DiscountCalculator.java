public class DiscountCalculator {
    public static void main(String[] args) {
        double purchaseAmount = 1200; // Hardcoded value
        boolean hasMembership = true; // Hardcoded membership status

        double discount = 0;
        if (purchaseAmount >= 1000) {
            discount = 20;
        } else if (purchaseAmount >= 500) {
            discount = 10;
        } else {
            discount = 5;
        }

        if (hasMembership) {
            discount += 5;
        }

        double finalPrice = purchaseAmount - (purchaseAmount * discount / 100);
        System.out.println("Total discount applied: " + discount + "%");
        System.out.println("Final price after discount: Rs. " + finalPrice);
    }
}
