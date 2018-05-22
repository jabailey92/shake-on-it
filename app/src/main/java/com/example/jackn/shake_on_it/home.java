package com.example.jackn.shake_on_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToHelp (View view){
        Intent intent = new Intent (home.this, help.class);
        startActivity(intent);
    }

    public void goToBet (View view){
        Intent intent = new Intent (home.this, activity_place_a_bet.class);
        startActivity(intent);
    }

}
