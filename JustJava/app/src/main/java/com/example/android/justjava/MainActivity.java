/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** this method is called when the '+' button is clicked
     * */

    public void increment(View  view){
        if(quantity==100){
            Toast.makeText(this,"YOu cannot have more than 100  Coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(++quantity);
    }


    /** this method is called when the '-' button is clicked
     * */
    public void decrement(View view){
        if(quantity==1){
            Toast.makeText(this,"YOu cannot have less than 1 Coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(--quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField=(EditText)findViewById(R.id.name);
        String name=nameField.getText().toString();
        EditText numberField=(EditText)findViewById(R.id.phonenumber);
        String Phone=numberField.getText().toString();
        CheckBox whippedcream=(CheckBox)findViewById(R.id.cream);
        boolean hasWhippedCream=whippedcream.isChecked();
        CheckBox chocolate=(CheckBox)findViewById(R.id.chocolate);
        boolean hasChocolate=chocolate.isChecked();
        int price=calculatePrice(hasWhippedCream,hasChocolate);
        displayMessage(createordersummary(price,hasWhippedCream,hasChocolate,name,Phone));
    }

    /**
     * Calculates the price of the order.
     *
     *
     */
    private int calculatePrice(boolean whippedcream,boolean chocloate) {
        int baseprice=5;
        if(whippedcream){
            baseprice=baseprice+1;
        }
        if(chocloate){
            baseprice=baseprice+2;
        }
        int price = quantity * baseprice;
        return price;
    }

    private String  createordersummary(int price,boolean x,boolean y,String name,String phone){
        String message="Name: "+name+"\nPhone Number: "+phone+"\nWhippedCream?"+x+"\nChocolate?"+y+"\nQuantity: "+quantity+"\nTotal: $"+price+"\nThank you!";
        return message;
        }

    /*
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.number);
        quantityTextView.setText(String.valueOf(num));
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}