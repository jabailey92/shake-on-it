package com.example.jackn.shake_on_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_place_a_bet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_a_bet);
    }

    public void goToMenu (View view){
        Intent intent = new Intent (activity_place_a_bet.this, home.class);
        startActivity(intent);
    }

    public void writeToFile (View view){

    }
}