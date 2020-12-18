package com.example.devocional;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.devocional.ui.Archive;
import com.example.devocional.ui.fragments.AddFragment;
import com.example.devocional.ui.fragments.RandomFragment;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String FILE_NAME = "example.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        showSelectedFragment(new AddFragment());
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.navigation_add) {
                    showSelectedFragment(new AddFragment());
                }
                if (menuItem.getItemId() == R.id.navigation_random) {
                    showSelectedFragment(new RandomFragment());
                    Archive.deArray_Archivo(AddFragment.people, getApplicationContext());
                }
                return true;
            }
        });
    }

    private void showSelectedFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container1, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}