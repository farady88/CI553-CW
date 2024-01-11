package catalogue;

import java.text.DecimalFormat;

import javax.swing.JTextArea;

public class Receipt {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public static void printReceipt(BetterBasket basket, JTextArea receiptTextArea) {
        receiptTextArea.append("===== Receipt =====");
        receiptTextArea.append(String.format("%-15s %-15s %-10s %-10s\n", "ProductNum", "Description", "Quantity", "Total Price"));
        receiptTextArea.append("--------------------------------------------------");

        for (Product product : basket) {
            String productNum = product.getProductNum();
            String description = product.getDescription();
            int quantity = product.getQuantity();
            double totalPrice = product.getPrice() * quantity;

            receiptTextArea.append(String.format("%-15s %-15s %-10d $%-10s\n", productNum, description, quantity,
                    DECIMAL_FORMAT.format(totalPrice)));
        }

        double grandTotal = calculateGrandTotal(basket);
        receiptTextArea.append("--------------------------------------------------");
        receiptTextArea.append(String.format("%-40s $%-10s\n", "Grand Total:", DECIMAL_FORMAT.format(grandTotal)));
        receiptTextArea.append("===================");
    }

    private static double calculateGrandTotal(BetterBasket basket) {
        double grandTotal = 0;
        for (Product product : basket) {
            int quantity = product.getQuantity();
            double totalPrice = product.getPrice() * quantity;
            grandTotal += totalPrice;
        }
        return grandTotal;
    }
}
