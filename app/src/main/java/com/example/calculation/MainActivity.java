package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    String ethAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_txt);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.btn_balance);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(ethAddress);
                BigDecimal balance = GetBalance.getBalance(ethAddress);
                System.out.println("Balance now :: " + balance);
                textView.setText(balance +"");
            }
        });
    }
}