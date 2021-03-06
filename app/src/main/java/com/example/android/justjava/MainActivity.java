package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private int checker = 0;
    private String priceMessage = "Thank You";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int number_of_coffee = quantity;
        int price = number_of_coffee * 700;
        if (quantity < 1)
            priceMessage = "\u270B\u270B Please order at least one cup!";
            else
                priceMessage="Thank You!";
                displayMessage(priceMessage);
                displayPrice(price);
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        checker = checker + 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        checker = checker - 1;
        if (quantity < 1)
            quantity = 0;
        display(quantity);
    }

    public void reset(View view) {
        if (checker < 2)
            priceMessage = "Click the (+) button, then order";
            else
                checker=2;
                if (checker > 1)
                    priceMessage = "Welcome";
                    quantity=0;
                    checker=1;
                    displayPrice(0);
                    display(quantity);
                    displayMessage(priceMessage);
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int amount) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(getString(R.string.coffee, amount));
    }

    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance(new Locale("en", "NG")).format(number));
    }

    private void displayMessage(String message) {
        TextView welcomeTextView = findViewById(R.id.welcome_text_view);
        welcomeTextView.setText(message);


    }
}