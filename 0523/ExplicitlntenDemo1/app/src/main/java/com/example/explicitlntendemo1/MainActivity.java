package com.example.explicitlntendemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnConvert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txt = (EditText) findViewById(R.id.txtC);
                int tempC = Integer.parseInt(txt.getText().toString());
                EditText editText = (EditText) findViewById(R.id.edtPlace);
                Intent intent = new Intent(MainActivity.this, FActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("c", tempC);
                bundle .putString("PLACE",editText.getText().toString());
                intent.putExtra(bundle);
                startActivity(intent);
            }
        });
    }
}



