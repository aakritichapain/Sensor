package com.aakriti.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {
    TextView tvGyro;
    SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        tvGyro = findViewById(R.id.tvGyro);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener gyrolistener =  new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if (event.values[1]<0) {
                    tvGyro.setText("Left");
                }else if (event.values[1]>0) {
                    tvGyro.setText("Right");
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        if (sensor !=null){

            sensorManager.registerListener(gyrolistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show();
        }

    }

    }




