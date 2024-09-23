package com.example.gui_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etFahrenheit , etCelsius;
    private Button btnConvertToCelsius, btnConvertToFahrenheit , btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etFahrenheit=findViewById(R.id.etFahrenheit);
        etCelsius=findViewById(R.id.etCelsius);
        btnConvertToCelsius=findViewById(R.id.btnConvertToCelsius);
        btnConvertToFahrenheit=findViewById(R.id.btnConvertToFahrenheit);
        btnClear=findViewById(R.id.btnClear);

        btnConvertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheit = etFahrenheit.getText().toString();
                if (!TextUtils.isEmpty(fahrenheit)) {
                    double f = Double.parseDouble(fahrenheit);
                    double celsius = (f - 32) * 5 / 9;
                    etCelsius.setText(String.format("%.2f", celsius));
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a Fahrenheit value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện khi nhấn nút Convert To Fahrenheit
        btnConvertToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsius = etCelsius.getText().toString();
                if (!TextUtils.isEmpty(celsius)) {
                    double c = Double.parseDouble(celsius);
                    double fahrenheit = (c * 9 / 5) + 32;
                    etFahrenheit.setText(String.format("%.2f", fahrenheit));
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a Celsius value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFahrenheit.setText("");
                etCelsius.setText("");
            }
        });
    }
}