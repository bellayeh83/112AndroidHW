package com.example.ch5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgGender;
    private RadioGroup rgType;
    private EditText editTextNumber2;
    private TextView lblOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGender = findViewById(R.id.rgGender);
        rgType = findViewById(R.id.rgType);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        lblOutput = findViewById(R.id.lblOutput);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayOutput();
            }
        });

    }

    private void displayOutput() {
        String gender = getSelectedGender();
        String type = getSelectedType();
        String quantity = editTextNumber2.getText().toString();
        int amount = calculateAmount(type, quantity);

        String output = gender + "\n" + type + "\n" + quantity + "張\n金額: " + amount;
        lblOutput.setText(output);
    }

    private String getSelectedGender() {
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedGenderId);
        return radioButton.getText().toString();
    }

    private String getSelectedType() {
        int selectedTypeId = rgType.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedTypeId);
        return radioButton.getText().toString();
    }

    private int calculateAmount(String type, String quantity) {
        int price = 0;
        switch (type) {
            case "全票(500)":
                price = 500;
                break;
            case "兒童票(250)":
                price = 250;
                break;
            case "學生票(400)":
                price = 400;
                break;
        }
        int qty = Integer.parseInt(quantity);
        return price * qty;
    }
}