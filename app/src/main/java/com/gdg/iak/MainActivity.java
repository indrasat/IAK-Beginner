package com.gdg.iak;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView tv_hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hello = (TextView) findViewById(R.id.txt_hello);
        final CheckBox cb_change = (CheckBox) findViewById(R.id.checkBox_changeBtn);
        cb_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean change = cb_change.isChecked();
                if(change){
                    Integer price = 0;
                    addText(view, price);
                }else {
                    Integer price = 100;
                    addText(view, price);
                }
            }
        });

        Button btn_send = (Button) findViewById(R.id.button_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = tv_hello.getText().toString();
                String[] addresses = new String[]{"indra.kurniawan717@gmail.com"};
                composeEmail(addresses, subject);
            }
        });

        Button btn_call = (Button) findViewById(R.id.button_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("085694921718");
            }
        });
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addText(View v, Integer value){

        //tv_hello.setText("Oke Bro!");
        Integer price = value;
        //Integer total = calculate(price);
        Child child = new Child();
        Integer total = child.calculate(price);
        //tv_hello.setText(total.toString());
        showResult(total);
    }
    /*
    public Integer calculate(Integer value){
        Integer total = value * 10;
        return total;
    }
    */

    public void showResult(Integer result){
        String total = result.toString();
        tv_hello.setText(total);

    }

}
