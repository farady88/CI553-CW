package clients.collection;

import catalogue.BetterBasket;
import catalogue.Receipt;

import javax.swing.*;
import java.awt.*;

public class ReceiptFrame extends JFrame {

    private BetterBasket basket;

    public ReceiptFrame(BetterBasket basket) {
        this.basket = basket;
        setTitle("Receipt");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        add(scrollPane, BorderLayout.CENTER);

        setSize(600,400);

        updateReceipt(receiptTextArea);

        
        Receipt.printReceipt(basket, receiptTextArea);

        pack();
        setLocationRelativeTo(null);
    }

        public void updateReceipt(JTextArea receiptTextArea) {
            receiptTextArea.setText("");
    
            Receipt.printReceipt(basket, receiptTextArea);
        }
    }
    

