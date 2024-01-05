package clients.collection;

import catalogue.BetterBasket;
import catalogue.Receipt;

import javax.swing.*;
import java.awt.*;

public class ReceiptFrame extends JFrame {

    public ReceiptFrame(BetterBasket basket) {
        setTitle("Receipt");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        add(scrollPane, BorderLayout.CENTER);

        
        Receipt.printReceipt(basket, receiptTextArea);

        pack();
        setLocationRelativeTo(null);
    }
}
