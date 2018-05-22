package com.example.jackn.shake_on_it;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {
    public static final int PERMISSIONS_SHIZZLE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        checkAndRequestPermissions();
    }

    private boolean checkAndRequestPermissions() {
        int permissionWriteStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (permissionWriteStorage != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_SHIZZLE);
        }
        return true;
    }
    public void goToHelp (View view){
        Intent intent = new Intent (home.this, help.class);
        startActivity(intent);
    }

    public void goToBet (View view){
        Intent intent = new Intent (home.this, place_a_bet.class);
        startActivity(intent);
    }

    public void goToHistory (View view){
        Intent intent = new Intent (home.this, history.class);
        startActivity(intent);
    }
}
