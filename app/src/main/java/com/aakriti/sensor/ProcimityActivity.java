package com.aakriti.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProcimityActivity extends AppCompatActivity {
    TextView tvProximity;
    SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procimity);

        tvProximity = findViewById(R.id.tvProximity);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        SensorEventListener proxilistener =  new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if (event.values[0]<4) {
                    tvProximity.setText("OBKECT IS NEAR");
                }else {
                    tvProximity.setText("OBJECT IS FAR");
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        if (sensor !=null){

            sensorManager.registerListener(proxilistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show();
        }

    }
    }

