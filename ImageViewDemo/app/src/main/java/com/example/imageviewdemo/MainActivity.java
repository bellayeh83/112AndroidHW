package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private ImageView imgOutput1, imgOutput2, imgOutput3, imgOutput4;
    private RadioGroup rgImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgOutput1 = findViewById(R.id.imgOutput1);
        imgOutput2 = findViewById(R.id.imgOutput2);
        imgOutput3 = findViewById(R.id.imgOutput3);
        imgOutput4 = findViewById(R.id.imgOutput4);

        rgImages = findViewById(R.id.rgImages);

        rgImages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 先將所有圖片隱藏
                imgOutput1.setVisibility(View.INVISIBLE);
                imgOutput2.setVisibility(View.INVISIBLE);
                imgOutput3.setVisibility(View.INVISIBLE);
                imgOutput4.setVisibility(View.INVISIBLE);

                // 根據選項顯示對應的圖片
                RadioButton radioButton = findViewById(checkedId);
                int drawableId = (int) radioButton.getTag();
                ImageView imgOutput = getImageViewByTag(drawableId);
                if (imgOutput != null) {
                    imgOutput.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private ImageView getImageViewByTag(int tag) {
        if (tag == R.drawable.burger) {
            return imgOutput1;
        } else if (tag == R.drawable.frenchfry) {
            return imgOutput2;
        } else if (tag == R.drawable.softdrink) {
            return imgOutput3;
        } else if (tag == R.drawable.soup) {
            return imgOutput4;
        } else {
            return null;
        }
    }

}