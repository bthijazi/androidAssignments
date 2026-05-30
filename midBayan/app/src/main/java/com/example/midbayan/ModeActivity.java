package com.example.midbayan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ModeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private Button btnMode;

    String[] tabs = {
            "First",
            "Second",
            "Third"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        btnMode = findViewById(R.id.btnMode);

        PagerAdapter adapter = new PagerAdapter(this);

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(
                tabLayout,
                viewPager,
                (tab, position) ->
                        tab.setText(tabs[position])
        ).attach();

        btnMode.setOnClickListener(this::showPopupMenu);

        getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {

                        int current =
                                viewPager.getCurrentItem();

                        if (current != 0) {
                            viewPager.setCurrentItem(0, true);
                        } else {
                            finish();
                        }
                    }
                });
    }

    private void showPopupMenu(View view) {

        PopupMenu popup =
                new PopupMenu(this, view);

        popup.getMenu().add("Light");
        popup.getMenu().add("Night");
        popup.getMenu().add("System");

        popup.setOnMenuItemClickListener(item -> {

            String title =
                    item.getTitle().toString();

            switch (title) {

                case "Light":
                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_NO);
                    break;

                case "Night":
                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_YES);
                    break;

                case "System":
                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    break;
            }

            return true;
        });

        popup.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()
                == android.R.id.home) {

            Intent intent =
                    new Intent(this,
                            MainActivity.class);

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}