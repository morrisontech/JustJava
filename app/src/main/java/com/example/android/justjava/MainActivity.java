package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increments quantity with minus button
     */
    public void decrement(View view)
    {
        quantity -= 1;
        display(quantity);
    }

    /**
     * Increments quantity with plus button
     */
    public void increment(View view)
    {
        quantity += 1;
        display(quantity);
    }

    public int calculatePrice()
    {
        price = 5;
        int totalPrice = quantity * price;
        return totalPrice;
    }

    public String createOrderSummary(int price)
    {
        String summary = String.format("Name: Craig Morrison\n" +
                "Quantity: %d\n" +
                "Total: %s\n" +
                "Thank you!",
                quantity,
                NumberFormat.getCurrencyInstance().format(calculatePrice()));
        return summary;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        price = calculatePrice();
        String priceString = createOrderSummary(price);
        displayMessage(priceString);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /*private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}