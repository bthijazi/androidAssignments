package com.example.assingmentbayan;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assingmentbayan.databinding.Fragment2Binding;

import java.util.Objects;

public class Fragment2 extends Fragment {

    private Fragment2Binding binding;
    private OnDataSendListener listener;

    public interface OnDataSendListener {
        void sendUserName(String name);
    }

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnDataSendListener) {
            listener = (OnDataSendListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater, container, false);

        String[] genders = {"Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, genders);
        Objects.requireNonNull(binding.spinnerGender).setAdapter(adapter);

        binding.buttonFragment2Continue.setOnClickListener(v -> {
            String name = binding.editTextName.getText().toString();
            String email = binding.editTextEmail.getText().toString();
            String university = binding.editTextUniversity.getText().toString();

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(getContext(), "Please enter name", Toast.LENGTH_SHORT).show();
            } else {
                listener.sendUserName(name);
            }
        });

        return binding.getRoot();
    }
}