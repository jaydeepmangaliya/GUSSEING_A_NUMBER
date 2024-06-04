package com.example.gusseinganumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    Button start;
    RadioButton r1,r2,r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.button);
        r1 =findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this ,  GameActivity.class);

                if(!r1.isChecked() && !r2.isChecked() && !r3.isChecked()){
                    Snackbar.make(view , " Please select digit" ,Snackbar.LENGTH_INDEFINITE).setAction("Close", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    }).show();
                }
                else  {
                    if(r1.isChecked()){
                        intent.putExtra("two",true);
                    }
                    if(r2.isChecked()){

                        intent.putExtra("three",true);
                    }
                    if(r3.isChecked()){
                        intent.putExtra("four",true);
                    }

                    startActivity(intent);
                }
            }
        });

    }
}