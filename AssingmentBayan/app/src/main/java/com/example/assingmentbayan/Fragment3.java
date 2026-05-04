package com.example.assingmentbayan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assingmentbayan.databinding.Fragment3Binding;

public class Fragment3 extends Fragment {

    private Fragment3Binding binding;
    private OnCheckBoxListener listener;
    private static final String USER_NAME = "user_name";

    public interface OnCheckBoxListener {
        void onCheckBoxChanged(boolean isChecked);
    }
    public static Fragment3 newInstance(String name) {
        Fragment3 fragment = new Fragment3();
        Bundle bundle = new Bundle();
        bundle.putString(USER_NAME, name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnCheckBoxListener) {
            listener = (OnCheckBoxListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Fragment3Binding.inflate(inflater, container, false);

        String name = getArguments().getString(USER_NAME);
        binding.textViewWelcome.setText("Welcome " + name);

        binding.buttonFinish.setEnabled(false);

        binding.checkBoxConfirm.setOnCheckedChangeListener((buttonView, isChecked) -> {
            listener.onCheckBoxChanged(isChecked);
            binding.buttonFinish.setEnabled(isChecked);

            if (isChecked) {
                binding.buttonFinish.setText("Finish");
            } else {
                binding.buttonFinish.setText("Continue");
            }
        });

        return binding.getRoot();
    }
}
