package com.example.jackn.shake_on_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public void goToMenuFromHistory (View view){
        Intent intent = new Intent (history.this, home.class);
        startActivity(intent);
    }
}
