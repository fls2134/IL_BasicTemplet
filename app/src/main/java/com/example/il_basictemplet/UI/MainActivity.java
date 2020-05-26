package com.example.il_basictemplet.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.il_basictemplet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.activity_main_bottom_navigation_view);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_container,fragment1)
                .commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.menu_activity_main_bottom_navigation_view_tab1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.activity_main_container, fragment1).commitAllowingStateLoss();
                        return true;

                    case R.id.menu_activity_main_bottom_navigation_view_tab2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.activity_main_container, fragment2).commitAllowingStateLoss();
                        return true;

                    default:
                        return false;
                }
            }
        });

    }
}
