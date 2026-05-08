package com.example.hellotoastbayan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private TextView showedNumber;
    private Button countButton;
    private Button zeroButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showedNumber = findViewById(R.id.text_display_count);
        countButton = findViewById(R.id.button_count);
        zeroButton = findViewById(R.id.button_zero);
        zeroButton.setBackgroundColor(ContextCompat.getColor(this,
                R.color.gray_btn));
    }
    public void showToast(View view) {
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
    }
    public void showCount(View view) {
        int count = Integer.parseInt(showedNumber.getText().toString());
        count++;
        showedNumber.setText(String.valueOf(count));
        if (count % 2 == 0) {
            countButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_btn));
        } else {
            countButton.setBackgroundColor(ContextCompat.getColor(this,R.color.green_btn));
        }
        zeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_btn));
    }
    public void showZero(View view) {
        showedNumber.setText("0");
        zeroButton.setBackgroundColor(ContextCompat.getColor(this,
                R.color.gray_btn));
    }
}