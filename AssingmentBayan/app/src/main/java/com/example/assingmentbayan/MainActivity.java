package com.example.assingmentbayan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assingmentbayan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnDataSendListener, Fragment3.OnCheckBoxListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Fragment1 fragment1 = Fragment1.newInstance(null, null);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment1)
                .commit();

        binding.buttonContinue.setOnClickListener(v -> {
            Fragment2 fragment2 = Fragment2.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public void sendUserName(String name) {
        Fragment3 fragment3 = Fragment3.newInstance(name);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment3)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCheckBoxChanged(boolean isChecked) {
    }
}