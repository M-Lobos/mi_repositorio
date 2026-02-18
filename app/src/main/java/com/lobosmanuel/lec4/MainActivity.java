package com.lobosmanuel.lec4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Button class declaration
    private Button btn_add;
    private Button btn_sub;
    private Button btn_times;
    private Button btn_div;
    private Button btn_clear;

    //input text & text view class declaration
    private TextView opResult;
    private EditText inputOne;
    private EditText inputTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    //initialize textview & textEdit
        opResult = findViewById(R.id.result);
        inputOne = findViewById(R.id.num1);
        inputTwo = findViewById(R.id.num2);

        // initialize buttons
        btn_add = findViewById(R.id.btn_add_id);
        btn_sub = findViewById(R.id.btn_sub_id);
        btn_times = findViewById(R.id.btn_times_id);
        btn_div = findViewById(R.id.btn_div_id);
        btn_clear = findViewById(R.id.clear_btn);

// click events
        // add button
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opResult.setText(String.valueOf(addOperation(
                        Integer.parseInt(inputOne.getText().toString()),
                        Integer.parseInt(inputTwo.getText().toString())
                )));
            }
        });

        // sub button
        btn_sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opResult.setText(String.valueOf(subOperation(
                        Integer.parseInt(inputOne.getText().toString()),
                        Integer.parseInt(inputTwo.getText().toString())
                )));
            }
        });

        // mult button
        btn_times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opResult.setText(String.valueOf(multOperation(
                        Integer.parseInt(inputOne.getText().toString()),
                        Integer.parseInt(inputTwo.getText().toString())
                )));
            }
        });

        // mult button
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opResult.setText(String.valueOf(divOperation(
                        Integer.parseInt(inputOne.getText().toString()),
                        Integer.parseInt(inputTwo.getText().toString())
                )));
            }
        });


        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

    }

    public double addOperation (double a, double b){
        return a+b;
    }
    public double subOperation (double a, double b){
        return a-b;
    }
    public double multOperation (double a, double b){
        return a*b;
    }
    @SuppressLint("SetTextI18n")
    public double divOperation (double a, double b){
        if (b == 0) {
            opResult.setText("Invalid operation");
    }
        return a / b;
    }

    public void clearFields() {
        opResult.setText("0");
        inputOne.setText("");
        inputTwo.setText("");
    }

}