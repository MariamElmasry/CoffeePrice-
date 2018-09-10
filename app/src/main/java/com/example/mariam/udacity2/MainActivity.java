package com.example.mariam.udacity2;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot add more than 100 cups of coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement(View view) {
        if (quantity <= 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot add less than 1 cup of coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

//        //هيفتح الخريط
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6, -122.3"));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//     }


        /*Find users name*/
        EditText name = (EditText) findViewById(R.id.nameOfCustomer);
        String Customer = name.getText().toString();
        Log.v("Main Activity", "Name " + Customer);

        /*Figure out if the user wants a whipped rea */
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCream.isChecked();

        /*Figure out if the user wants hoolate */
        CheckBox Chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = Chocolate.isChecked();
        Log.v("Main Activity", "Has Whipped Cream " + hasWhippedCream);

        CheckBox Caramel = (CheckBox) findViewById(R.id.caramel);
        boolean hasCaramel = Caramel.isChecked();

        /*Figure out if the user wants Caramel  */

 //       int price = calculatePrice(hasWhippedCream, hasChocolate, hasCaramel);
        //      String priceMessage = createOrderSummary(Customer, price, hasWhippedCream, hasChocolate, hasCaramel);
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + Customer);
//        intent.putExtra(Intent.EXTRA_TEXT ,priceMessage );
//        if (intent.resolveActivity(getPackageManager()) != null) {
//        startActivity(intent);
//          }
//        displayMessage(createOrderSummary(Customer, price, hasWhippedCream, hasChocolate, hasCaramel));

//        /** or set it like that they are the same */
         int price = calculatePrice(hasWhippedCream, hasChocolate, hasCaramel);
          String priceMessage = createOrderSummary (Customer, price, hasWhippedCream, hasChocolate, hasCaramel);
          displayMessage(priceMessage);
//

    }

    /**
     * Calculates the price of the order.
     * /*@param Customer is the name of user
     * /*@param addWhippedCream whether or not the user wants WhippedCream
     * /*@param addChocolate whether or not the user wants Chocolate
     * /* @param quantity is the number of cups of coffee ordered
     * /* @param pricePerCup is the number of coffees
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate, boolean addCaramel) {
        //prie of one up of offee
        int basePrice = 5;

        //prie if a user wants whipped rea topping
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        if (addCaramel) {
            basePrice = basePrice + 3;
        }
        //total order price
        return quantity * basePrice;

    }

    @SuppressLint("StringFormatInvalid")
    private String createOrderSummary(String Cutomer, int price, boolean addWhippedCream, boolean addChocolate, boolean addCaramel) {
        String priceMessage = getString(R.string.custotomer_name, Cutomer);
       /// priceMessage = priceMessage + ---> priceMessage +=
        priceMessage += "\n " + getString(R.string.Whipped_cream, addWhippedCream) + addWhippedCream;
        priceMessage += "\n " + getString(R.string.chocolate, addChocolate) + addChocolate;
        priceMessage += "\n Add Caramel? " + addCaramel;
        priceMessage += "\n Quantity " + quantity;
        priceMessage += "\n Total: $" + price;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.zero_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
