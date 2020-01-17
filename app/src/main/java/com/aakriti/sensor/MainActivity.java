package com.aakriti.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAxis, btnSensor, btnGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAxis =  findViewById(R.id.btnAxis);
        btnSensor =  findViewById(R.id.btnSensor);
        btnGyro =  findViewById(R.id.btnGyro);

        btnAxis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AccelerometerActivity.class);
                startActivity(intent);
            }
        });


        btnSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(intent);

            }
        });

        btnGyro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GyroscopeActivity.class);
                startActivity(intent);
            }
        });
    }
}
